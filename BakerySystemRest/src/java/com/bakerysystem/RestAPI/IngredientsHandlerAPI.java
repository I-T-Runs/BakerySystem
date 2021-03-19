/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.RestAPI;

import com.bakerysystem.Model.*;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Themba
 */
public class IngredientsHandlerAPI {
 
     private final String SUCCESSFUL = "SUCCESSFUL!";
    private final String FAILED = "FAILED!";
 
    // ADDING A CATEGORY
    @POST
    @Path("/add-ingredient-stock")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addIngredient(){

        // IF STATEMENT THAT WILL REPRESENT SUCCESSFUL CONDITION
       return FAILED;
    }
    
    @DELETE
    @Path("/delete-ingredient-stock-item")
    public String removeIngredient(@PathParam("ingredientid") int ingredientID){
 
                // IF STATEMENT THAT WILL REPRESENT SUCCESSFUL CONDITION
        return FAILED;
    }
    
    @PUT
    @Path("/restock/{ingredientid}")
    public String restock(@PathParam("ingredientid") int ingredientID, @FormParam("optRestockAmount") int quantity){ // WHICH IS Essentially an Edit of the ingredient ++Quantity
                // ingredient =  new CategoryDaoImpl().restockIngredient(ingredientID, quantity);
        return FAILED;
    }
    
    @PUT
    @Path("/edit")
    public String editIngreidient(@PathParam("ingredientid") int ingredientID){ // changin the name of the ingredient  [MEASUREMENT FIELD - kg, l, g .etc]
        
        //  ingredient =  new CategoryDaoImpl().updateIngredient();
        
        return FAILED;
    }
    
    @GET
    @Path("/ingredients")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ingredient> retrieveAllIngredients(){
        //List<Ingredient> ingredients =  new CategoryDaoImpl().getIngredients();
        
        // return ingredients;
        return null;
    }
    
    @GET
    @Path("/ingredient-item")
    @Produces(MediaType.APPLICATION_JSON)
    public Ingredient getIngredient(@PathParam("ingredientid") int ingredientID){
        
        // return new dao.getIngredient(ingredientID);
        return null;
    }
}
