package com.example.onlineshoppingsystem.cartLine.service;

import com.example.onlineshoppingsystem.cart.dto.Cart;
import com.example.onlineshoppingsystem.cart.exception.CartNotAvailableException;
import com.example.onlineshoppingsystem.cartLine.dto.CartLine;
import com.example.onlineshoppingsystem.product.dto.Product;

import java.util.List;
import java.util.Optional;


public interface CartLineService {
    public CartLine addCartLine(CartLine cartLine);
    public List<CartLine> viewCart();
    public CartLine findCartLineByCartAndProduct(Cart cart,Product product);
    public CartLine removeItemsFromCart(CartLine cartLine);
    public void deleteCartLine(int cartLine);
    public float sumByPrice(Cart cart);
    public List<CartLine> getByCart(Cart cart);
    public void deleteByCart(Cart cart);
    List<CartLine> findCartLineByCart(Cart cart) throws CartNotAvailableException;
    List<CartLine> deleteCartLinesByCart(Cart cart);
}
