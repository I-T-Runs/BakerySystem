/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.RestAPI;

import com.bakerysystem.Model.Category;
import com.bakerysystem.Model.Product;
import com.bakerysystem.Model.User;
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

@Path("catagories-content")
public class CategoryHandlerAPI {
     
    private final String SUCCESSFUL = "SUCCESSFUL!";
    private final String FAILED = "FAILED!";
 
    // ADDING A CATEGORY
    @POST
    @Path("/create-category")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createCategory(){
       
       // REMEMBER, SHOULD ONLY BE PERMITTED IF THEYRE LOGGED IN AS ADMIN
       // CategoryDao dao = new CategoryDaoImpl();
       
        // make an object out of a given string
        // create and call dao for storage
        // should also take in list of the items to be linked with the category
        
       // Category c = 
       
        // IF STATEMENT THAT WILL REPRESENT SUCCESSFUL CONDITION
       return FAILED;
    }
    
    @DELETE
    @Path("/delete-category")
    public String removeCategory(){
        
                
                // IF STATEMENT THAT WILL REPRESENT SUCCESSFUL CONDITION
        return FAILED;
    }
    
    @PUT
    @Path("/edit")
    public boolean editCategoryDetails(){
        
        return false;
    }
    
    @GET
    @Path("/categories")
    public List<Category> retrieveAllCategories(){
        
        return null;
    }
    
    @GET
    @Path("/populate-categorised/{category}")
    @Produces("applciation/json")
    public List<Product> retrieveAllCategories(@PathParam("category") String selectedCategory){
        //List<Product> products =  new CategoryDaoImpl().getProductsFromCategory(selectedCategory)
        
        // return products;
        return null;
    }
}
