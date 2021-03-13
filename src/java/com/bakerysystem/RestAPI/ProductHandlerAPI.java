//package com.bakerysystem.RestAPI;
//
//import com.bakerysystem.Daos.ProductDao;
//import com.bakerysystem.Daos.ProductDaoImpl;
//import com.bakerysystem.Model.*;
//import java.io.File;
//import java.util.ArrayList;
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
///**
// *
// * @author Themba
// */
//
//// app/resources/catalogue
//
//@Path("/products")
//public class ProductHandlerAPI {
//
//    private final String SUCCESSFUL = "SUCCESSFUL";
//    private final String FAILED = "FAILED";
//    
//    @GET
//    @Path("/catalogue")
//    @Produces(MediaType.APPLICATION_JSON)
//    public ArrayList<Product> getProducts(){//String displayAllProducts() {
//        
//        ArrayList<Product> catalogue = new ArrayList<>(); // new ProductDaoImpl().getProducts();
//        ArrayList<Ingredient> recipe = new ArrayList<>();
//        
//        for (int i = 0; i < 3; i++) {
//            recipe.add(new Ingredient(((i + 1)), ("ingredient" + (i + 1)), (((int) (Math.random() * 6) + 1))));
//        }
//        
//        for (int i = 0; i < 20; i++) {            
//            Product prod = new Product(i, "Product " + (i + 1),".\\images\\imagename"+i+".file",111,10.99,0,recipe,"I am a product description","And This here is a warnging");
//            catalogue.add(prod);
//            
//        }
//        
//        return catalogue;
//    }
//    
//    @GET
//    @Path("/product/{productid}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getAProduct(@PathParam("productid") int productid ){//String displayAllProducts() {
//        ArrayList<Ingredient> recipe = new ArrayList<Ingredient>();
//        for (int i = 0; i < 3; i++) {
//            recipe.add(new Ingredient(((i + 1)), ("ingredient" + (i + 1)), (((int) (Math.random() * 6) + 1))));
//        }        
//        Product prod =  new Product(productid, "name", FAILED, productid, 54.22, 22, recipe, SUCCESSFUL, SUCCESSFUL);
////                                                                    rs.getString("Photo"),
////        Product prod = new ProductDaoImpl().getProduct(productid);//new Product(productid, "Product " + productid,".\\images\\imagename"+productid+".file",111,10.99,0,recipe,"I am a product description","And This here is a warning");//new ProductDaoImpl().getProduct(productid);
//        
//        if(prod.getProductID() == productid){
//            return Response.status(Response.Status.OK).entity(prod).build();
//        }
//        
//        prod.setRecipeArr(recipe);
//
//        return Response.status(Response.Status.OK).entity("Couldn't get product").build();
//    }
//    
//   
//    
//    @DELETE
//    @Path("/remove/{productid}")
//    public String removeProduct(@QueryParam("productid") int productid){
//        new ProductDaoImpl().removeProduct(productid);
//        return FAILED;
//    }
//    
//    @PUT
//    @Path("/update/{productid}")
//    public String editProduct(){
////        new ProductDaoImpl().updateProduct(productid);        
//// GIVE DB a PRODUCT INSTANCE
//        return FAILED;
//    }
//    
//     @GET
//    @Path("/add-product")
//    public String addProduct(){ //Query @FormParam("")){
//        
//        // GIVE DB a PRODUCT INSTANCE
//        //new ProductDaoImpl().addProduct(prod);
//        
//        return "Hello";
//    }
//
//}
