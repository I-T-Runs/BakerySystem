/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.RestAPI;

import com.bakerysystem.Model.*;
import com.bakerysystem.Services.IngredientServiceImpl;
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
    public String addIngredient(Ingredient ingr){

        if(new IngredientServiceImpl().addIngredient(ingr) == true){
            return SUCCESSFUL;
        }
       return FAILED;
    }
    
    @DELETE
    @Path("/delete-ingredient-stock-item/{id}")
    public String removeIngredient(@PathParam("id") int ingredientID){

        if(new IngredientServiceImpl().deleteIngredient(ingredientID) == true){
            return SUCCESSFUL;
        }
        return FAILED;
    }
    
    @PUT
    @Path("/restock/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String restock(Ingredient ingr){//@PathParam("ingredientid") int ingredientID, @FormParam("optRestockAmount") int quantity){ // WHICH IS Essentially an Edit of the ingredient ++Quantity
                    //                    RESTOCKS  ->  quantity of whatever will be added to existing one
//                 ingr =  new IngredientServiceImpl().restockIngredient(ingr.getIngredientId(), ingr.getQuantity());
        return FAILED;
    }
    
    @PUT
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    public String editIngreidient(Ingredient ingredient){ // changin the name of the ingredient  [MEASUREMENT FIELD - kg, l, g .etc]
        
          if(new IngredientServiceImpl().updateIngredient(ingredient) == true){
              return SUCCESSFUL;
          }
        return FAILED;
    }
    
    @GET
    @Path("/ingredients")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ingredient> retrieveAllIngredients(){
        List<Ingredient> ingredients =  new IngredientServiceImpl().getAllIngredients();
        
        // return ingredients;
        return ingredients;
    }
    
    @GET
    @Path("/ingredient-item/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ingredient getIngredient(@PathParam("id") int ingredientID){
        
         return new IngredientServiceImpl().getIngredient(ingredientID);
//        return null;
    }
}
