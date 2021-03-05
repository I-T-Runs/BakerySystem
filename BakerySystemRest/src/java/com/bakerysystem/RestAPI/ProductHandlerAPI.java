package com.bakerysystem.RestAPI;

import com.bakerysystem.Daos.ProductDao;
import com.bakerysystem.Daos.ProductDaoImpl;
import com.bakerysystem.Model.*;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Themba
 */

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
        
//        for (int i = 0; i < 20; i++) {
//            
//            Product prod = new Product(i, "Product " + (i + 1), null, recipe);
//            Product prod1 = new Product(i,"Product",)
//            catalogue.add(prod);
//        }

        
        
        return catalogue;
    }
    
    @GET
    @Path("/product")
    @Produces(MediaType.APPLICATION_JSON)
    public Product displayAProduct(@QueryParam("productid") int productid ){//String displayAllProducts() {
        
        ArrayList<Ingredient> recipe = new ArrayList<Ingredient>();
        for (int i = 0; i < 3; i++) {
            recipe.add(new Ingredient(((i + 1)), ("ingredient" + (i + 1)), (((int) (Math.random() * 6) + 1))));
        }        
//        Product prod =  new Product(productid, "Product " + productid , null, recipe, 0);
//                                                                    rs.getString("Photo"),
        Product prod = new ProductDaoImpl().getProduct(productid);
        prod.setRecipeArr(recipe);
        
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
