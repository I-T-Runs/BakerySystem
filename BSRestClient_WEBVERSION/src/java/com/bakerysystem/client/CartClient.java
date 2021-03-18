/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.client;

import com.bakerysystem.model.Cart;
import com.bakerysystem.properties.BSConfig;
import java.util.ArrayList;

/**
 *
 * @author Themba
 */
public class CartClient {
    private DefaultClient<Cart> dc;
    
    public CartClient() {
            dc = new DefaultClient<>("cart-stuff");        
    }
    
    public static void main(String [] args){
        new CartClient();
    }
    
     public String addCart(Cart cart){
        return dc.create(cart, "add");
    }
    
    public Cart getCart(int cartid) {
       return dc.get(cartid, "user-cart/{id}");
    }
    
//    public   String remove(int cartId) {
//        return dc.remove(cartId, "remove");
//    }
    
    
    public String updateCart(Cart cus) {
        return dc.update(cus, "update-cart");
        //        remove item and just update can also be remove from cart
    }

}
