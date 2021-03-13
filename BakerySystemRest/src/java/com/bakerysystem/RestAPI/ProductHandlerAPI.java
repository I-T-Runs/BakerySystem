/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.RestAPI;

import com.bakerysystem.Model.*;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Themba
 */

//v   application/

@Path("/")
public class ProductHandlerAPI {
    
    //  app/product
    
    @GET
    @Path("/catalogue")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> displayAllProducts(){//String displayAllProducts() {
        
        ArrayList<Product> catalogue = new ArrayList<>();
        ArrayList<Ingredient> recipe = new ArrayList<Ingredient>();
        for (int i = 0; i < 3; i++) {
            recipe.add(new Ingredient(((i + 1)), ("ingredient" + (i + 1)), (((int) (Math.random() * 6) + 1))));
        }
        
        for (int i = 0; i < 20; i++) {
            Product prod = new Product(i, "Product " + (i + 1), null, recipe, 0); 
            catalogue.add(prod);
        }
        
        return catalogue;
    }
    
    @GET
    @Path("/product/{productid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product displayAProduct(@PathParam("productid") int productid ){//String displayAllProducts() {
        
        ArrayList<Ingredient> recipe = new ArrayList<Ingredient>();
        for (int i = 0; i < 3; i++) {
            recipe.add(new Ingredient(((i + 1)), ("ingredient" + (i + 1)), (((int) (Math.random() * 6) + 1))));
        }
        
        Product prod =  new Product(productid, "Product " + productid , null, recipe, 0);
        
        return prod;
    }
    
    
    @DELETE
    @Path("/remove/{productid}")
    public boolean removeProduct(@PathParam("productid") int productid){
        // remove product(productid)
        
        return false;
    }
    
    @PUT
    @Path("/update/{productid}")
    public boolean editProduct(){
        // remove product(productid)
        
        return false;
    }
}
