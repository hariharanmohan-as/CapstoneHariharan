package com.example.onlineshoppingsystem.cartLine.repo;

import com.example.onlineshoppingsystem.cart.dto.Cart;
import com.example.onlineshoppingsystem.cartLine.dto.CartLine;
import com.example.onlineshoppingsystem.product.dto.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartLineRepo extends JpaRepository<CartLine, Integer> {
    public CartLine findCartLineByCartAndProduct(Cart cart,Product product);
    @Transactional
    public void deleteByCartLineId(int cartLineId);
    @Query("SELECT SUM(l.itemTotal) FROM CartLine l where l.cart = :cart")
    public float sumByPrice(@Param("cart") Cart cart);
    public List<CartLine> findByCart(Cart cart);
    public void deleteByCart(Cart cart);
    List<CartLine> findCartLineByCart(Cart cart);
    List<CartLine> deleteCartLinesByCart(Cart cart);
}
