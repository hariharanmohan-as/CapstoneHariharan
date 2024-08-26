package com.example.onlineshoppingsystem.cartLine.service;

import com.example.onlineshoppingsystem.cart.dto.Cart;
import com.example.onlineshoppingsystem.cart.exception.CartNotAvailableException;
import com.example.onlineshoppingsystem.cartLine.dto.CartLine;
import com.example.onlineshoppingsystem.cartLine.repo.CartLineRepo;
import com.example.onlineshoppingsystem.product.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartLineServiceImpl implements CartLineService{
    @Autowired
    private CartLineRepo repo;
    @Override
    public CartLine addCartLine(CartLine cartLine) {
        return repo.save(cartLine);
    }

    @Override
    public List<CartLine> viewCart() {
        return repo.findAll();
    }

    @Override
    public CartLine findCartLineByCartAndProduct(Cart cart, Product product) {
        return repo.findCartLineByCartAndProduct(cart,product);
    }

    @Override
    public CartLine removeItemsFromCart(CartLine cartLine) {
        return repo.save(cartLine);
    }

    @Override
    public void deleteCartLine(int cartLine) {
        repo.deleteByCartLineId(cartLine);
    }

    @Override
    public float sumByPrice(Cart cart) {
        return repo.sumByPrice(cart);
    }

    @Override
    public List<CartLine> getByCart(Cart cart) {
        return repo.findByCart(cart);
    }

    @Override
    public void deleteByCart(Cart cart) {
        repo.deleteByCart(cart);
    }

    @Override
    public List<CartLine> findCartLineByCart(Cart cart) throws CartNotAvailableException {
        List<CartLine> find = repo.findCartLineByCart(cart);
        if (find.isEmpty()) {
            throw new CartNotAvailableException(find);
        }
        return find;
    }

    @Override
    public List<CartLine> deleteCartLinesByCart(Cart cart) {
        return repo.deleteCartLinesByCart(cart);
    }


}
