package com.example.onlineshoppingsystem.cart.controller;


import com.example.onlineshoppingsystem.cart.dto.Cart;
import com.example.onlineshoppingsystem.cart.exception.CartNotAvailableException;
import com.example.onlineshoppingsystem.cart.service.CartService;
import com.example.onlineshoppingsystem.cartLine.dto.CartLine;
import com.example.onlineshoppingsystem.cartLine.service.CartLineService;
import com.example.onlineshoppingsystem.customer.dto.Customer;
import com.example.onlineshoppingsystem.customer.exception.CustomerIntNotFound;
import com.example.onlineshoppingsystem.orderLine.dto.OrderLine;
import com.example.onlineshoppingsystem.orders.dto.Orders;
import com.example.onlineshoppingsystem.orders.service.OrderService;
import com.example.onlineshoppingsystem.product.dto.Product;
import com.example.onlineshoppingsystem.product.exception.ProductNotFoundException;
import com.example.onlineshoppingsystem.product.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shop/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private CartLineService cartLineService;
    @Autowired
    private OrderService service;
    @Autowired
    private ProductService prodService;

    @PostMapping("/addToCart")
    public void addTocart(@RequestParam("custId") int custId, @RequestParam ("productId") int productId) throws ProductNotFoundException, CustomerIntNotFound {
        Customer customer = cartService.findByCustId(custId);
        Product product = prodService.findById(productId);
        Optional<Cart> cart1 = cartService.findByCustomer(customer);
        System.out.println(cart1);
        if (cart1.isEmpty()) {
            Cart cart = new Cart();
            cart.setCustomer(cartService.findByCustId(custId));
            CartLine line = new CartLine();
            line.setCartLineId(cart.getCartId());
            line.setQuantity(1);
            line.setUnitPrice(product.getProductPrice());
            line.setItemTotal(line.getUnitPrice() * line.getQuantity());
            line.setProduct(product);
            line.setCart(cart);
            cartService.addCart(cart);
            cartLineService.addCartLine(line);
        } else {
            CartLine line = cartLineService.findCartLineByCartAndProduct(cart1.get(), product);
            if (line == null) {
                CartLine line1 = new CartLine();
                line1.setQuantity(1);
                line1.setUnitPrice(product.getProductPrice());
                line1.setItemTotal(line1.getUnitPrice() * line1.getQuantity());
                line1.setProduct(product);
                line1.setCart(cart1.get());
                cartLineService.addCartLine(line1);
            } else {
                line.setQuantity(line.getQuantity() + 1);
                line.setItemTotal(line.getUnitPrice() * line.getQuantity());
                cartLineService.addCartLine(line);
            }
        }

    }
    @GetMapping("/view")
    public List<CartLine> viewCart(){
        return cartLineService.viewCart();
    }
    @GetMapping("/cartId/{cartId}")
    public List<CartLine> findByCartId(@PathVariable("cartId") Cart cartId) throws CartNotAvailableException {
        return cartLineService.findCartLineByCart(cartId);
    }
    @Transactional
    @DeleteMapping("/deleteCart/{cartId}")
    public void deleteCart(@PathVariable("cartId") Cart cartId)  {
        cartLineService.deleteCartLinesByCart(cartId);
    }

    @DeleteMapping("/removeFromCart")
    public void removeFromCart(@RequestParam("custId") int custId, @RequestParam ("productId") int productId) throws ProductNotFoundException, CustomerIntNotFound, CartNotAvailableException {
        Customer customer = cartService.findByCustId(custId);
        Product product = prodService.findById(productId);
        Optional<Cart> cart1 = cartService.findByCustomer(customer);
        if (cart1.isPresent()) {
            CartLine line = cartLineService.findCartLineByCartAndProduct(cart1.get(), product);
            if (line != null) {
                System.out.println(line.getQuantity());
                if(line.getQuantity()-1 == 0) {
                    System.out.println(line.getQuantity());
                    cartLineService.deleteCartLine(line.getCartLineId());
                }
                else {
                    line.setQuantity(line.getQuantity() - 1);
                    line.setItemTotal(line.getUnitPrice() * line.getQuantity());
                    cartLineService.removeItemsFromCart(line);
                }
            }
        }
    }
    @Transactional
    @PostMapping("/checkOut")
    public String placeOrder(@RequestParam("custId") int custId) throws ProductNotFoundException, CustomerIntNotFound, CartNotAvailableException {
        Customer customer = cartService.findByCustId(custId);
        Optional<Cart> cart1 = cartService.findByCustomer(customer);
        List<CartLine> cartLine = cartLineService.getByCart(cart1.get());
        if (cartLine.isEmpty()) {
            throw new CartNotAvailableException(cartLine);
        }
        Orders order = new Orders();
        order.setCustomer(customer);
        order.setDateOfOrder(new Date(System.currentTimeMillis()));
        order.setTotalPrice(cartLineService.sumByPrice(cart1.get()));
        List<CartLine> cartLines = cartLineService.getByCart(cart1.get());
        List<OrderLine> ordersList = new ArrayList<>();
        for (CartLine cartline : cartLines){
            if(prodService.findById(cartline.getProduct().getProductId()).getProductStock()>cartline.getQuantity()){
                OrderLine line = new OrderLine();
                line.setOrders(order);
                line.setProduct(cartline.getProduct());
                line.setQuantity(cartline.getQuantity());
                line.setUnitPrice(cartline.getUnitPrice());
                line.setItemTotal(cartline.getItemTotal());
                ordersList.add(line);
                Product product = prodService.findById(cartline.getProduct().getProductId());
                product.setProductStock(product.getProductStock()-cartline.getQuantity());
                prodService.createProduct(product);
            }
            else {
                return cartline.getProduct().getProductId()+"Out of Stock";
            }
        }
        order.setOrderLineList(ordersList);
        service.save(order);
        cartLineService.deleteByCart(cart1.get());
        return "order processed successfully";
    }

}
