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
        
        ArrayList<Product> catalogue = new ProductDaoImpl().getProducts();
        ArrayList<Ingredient> recipe = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            recipe.add(new Ingredient(((i + 1)), ("ingredient" + (i + 1)), (((int) (Math.random() * 6) + 1))));
        }
        
        
        
        return catalogue;
    }
    
    @GET
    @Path("/product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getAProduct(@PathParam("id") int productid ){//String displayAllProducts() {
        
        
        return new ProductServiceImpl().getProduct(productid) ;
//                                                                    rs.getString("Photo"),
//        Product prod = new ProductDaoImpl().getProduct(productid);//new Product(productid, "Product " + productid,".\\images\\imagename"+productid+".file",111,10.99,0,recipe,"I am a product description","And This here is a warning");//new ProductDaoImpl().getProduct(productid);
        
//        if(prod.getProductID() == productid){
//            return Response.status(Response.Status.OK).entity(prod).build();
//        }
//        
//        prod.setRecipeArr(recipe);
//
//        return Response.status(Response.Status.OK).entity("Couldn't get product").build();
    }
    
   
    
    @DELETE
    @Path("/remove/{id}")
    public String removeProduct(@PathParam("id") int productid){
        
        if(new ProductDaoImpl().removeProduct(productid) == true){
            return SUCCESSFUL;
        }
        
        return FAILED;
    }
    
    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String editProduct(Product prod){
                
// GIVE DB a PRODUCT INSTANCE
        if(new ProductDaoImpl().updateProduct(prod)){
            return SUCCESSFUL;
        }
        return FAILED;
    }
    
     @GET
    @Path("/add-product")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addProduct(Product prod){ //Query @FormParam("")){
        
        // GIVE DB a PRODUCT INSTANCE
        
        if(new ProductDaoImpl().addProduct(prod) == true){
            return SUCCESSFUL;
        }
        return FAILED;
    }

}
