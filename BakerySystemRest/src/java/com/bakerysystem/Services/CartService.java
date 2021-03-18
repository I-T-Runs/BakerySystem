package com.bakerysystem.Services;

import com.bakerysystem.Model.Cart;

/**
 *
 * @author Themba
 */
public interface CartService {
    public String addToCart(Cart cart);
//    public String removeFromCart();
    public Cart getCart(int userid);
    public String updateCart(Cart cart);
}
