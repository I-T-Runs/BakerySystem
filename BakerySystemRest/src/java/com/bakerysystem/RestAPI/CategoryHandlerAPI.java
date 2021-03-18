/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.RestAPI;

import com.bakerysystem.Model.Category;
import com.bakerysystem.Model.Product;
import com.bakerysystem.Model.User;
import com.bakerysystem.Services.CategoryServiceImpl;
import java.util.ArrayList;
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
    public String createCategory(Category cat){
       
        if(new CategoryServiceImpl().addCategory(cat) == true){
            return SUCCESSFUL;
        }
       return FAILED;
    }
    
    @DELETE
    @Path("/delete-category/{id}")
    public String removeCategory(@PathParam("id") int catid){
        if(new CategoryServiceImpl().deleteCategory(catid) == true){
            return SUCCESSFUL;
        }
       return FAILED;
    }
    
    @PUT
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    public String editCategoryDetails(Category cat){
        if(new CategoryServiceImpl().updateCategory(cat) == true){
            return SUCCESSFUL;
        }
       return FAILED;
    }
    
    @GET
    @Path("/categories")
    public ArrayList<Category> retrieveAllCategories(){
        return new CategoryServiceImpl().getAllCategories();
    }
    
    @GET
    @Path("/category/{id}")
    @Produces("applciation/json")
    public Category getCategory(@PathParam("id") int selectedCategory){
        return new CategoryServiceImpl().getCategory(selectedCategory);
    }
}
