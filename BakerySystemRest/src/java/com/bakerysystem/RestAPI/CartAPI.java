/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.RestAPI;

import com.bakerysystem.Model.Cart;
import com.bakerysystem.Services.CartServiceImpl;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Themba
 */
@Path("cart-stuff")
public class CartAPI {
    
    @GET
    @Path("user-cart/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cart getCart(@PathParam("{id}") int cartid){
        return new CartServiceImpl().getCart(cartid);
    }
    
    @PUT               //    changing quantity
    @Path("update-cart")
    public String updateCart(Cart cart){
        return new CartServiceImpl().updateCart(cart);
    }
    
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addToCart(Cart cart){
        return new CartServiceImpl().addToCart(cart);
    }
}

