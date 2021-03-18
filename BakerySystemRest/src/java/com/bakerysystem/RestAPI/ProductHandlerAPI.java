package com.bakerysystem.RestAPI;

import com.bakerysystem.Daos.ProductDao;
import com.bakerysystem.Daos.ProductDaoImpl;
import com.bakerysystem.Model.*;
import com.bakerysystem.Services.ProductServiceImpl;
import java.io.File;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Themba
 */

// app/resources/catalogue

@Path("/products")
public class ProductHandlerAPI {

    private final String SUCCESSFUL = "SUCCESSFUL";
    private final String FAILED = "FAILED";
    
    @GET
    @Path("/catalogue")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getProducts(){//String displayAllProducts() {
        
                            //      HARD CODE FOR NO DB API
        return new ProductServiceImpl().getAllProducts();//catalogue;
    }
    
    @GET
    @Path("/product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getAProduct(@PathParam("id") int productid ){//String displayAllProducts() {
        
        return new ProductServiceImpl().getProduct(productid);

    }
   
    @DELETE
    @Path("/remove/{id}")
    public String removeProduct(@PathParam("id") int productid){
        if(new ProductDaoImpl().removeProduct(productid)==true){
            return SUCCESSFUL;
        }
        return FAILED;
    }
    
    @PUT
    @Path("/update")
    public String editProduct(Product prod){

        if(new ProductDaoImpl().updateProduct(prod)==true){
            return SUCCESSFUL;
        }
        return FAILED;
    }
    
     @GET
    @Path("/add-product")
     @Consumes(MediaType.APPLICATION_JSON)
    public String addProduct(Product prod){ //Query @FormParam("")){
        
        // GIVE DB a PRODUCT INSTANCE
         if(new ProductDaoImpl().addProduct(prod)==true){
            return SUCCESSFUL;
        }
        return FAILED;
    }

}
