package com.bakerysystem.RestAPI;

//import com.bakerysystem.Daos.UserDaoImpl;
import com.bakerysystem.Daos.CustomerDaoImpl;
import com.bakerysystem.Model.Customer;
import com.bakerysystem.Model.User;
import com.bakerysystem.Services.CustomerServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Themba
 */

@Path("/users")
public class AccountsAPI {
    
    private final String SUCCESSFUL = "SUCCESSFUL";
    private final String FAILED = "FAILED";
    
    @GET
    @Path("/login/{username}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer signingInUser(@PathParam("username") String username, @PathParam("password") String password){
//        Customer user = new Customer(321, "firstname", "lastname", "email", "tel-home", "mobile-no", "identityNo", 321, "password"); // new CustomerServiceImpl().login(username,password);
        //User user = null;//new UserDaoImpl().getUser(username,password); 
       Customer user = new CustomerServiceImpl().login(username, password);
       
       if(user != null){
           return user;
       }else{
           return null;
       }
    }
    
    // app/users/register
    
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces("application/text" )
    public Response registerInUser(Customer regU){
       Customer user = regU;

       user =  new CustomerServiceImpl().registerCustomer(regU);//regU ; 
        if(user != null){
//            user.setFirstName("LARR"+"977");
            return Response.status(Response.Status.OK).entity(user).build();
        }//else{
         ////   return Response.status(Response.Status.OK).entity("A user with this email already exists!").build();
        //}
//       user.setFirstName("parr");  
         return Response.status(Response.Status.OK).entity("A user account already exists!").build();
    }
    
    @DELETE
    @Path("/remove/{userid}")
    public Response removeUser(@PathParam("userid") int userID){
         String result = (new CustomerServiceImpl().deleteCustomer(userID)) == true ? SUCCESSFUL : FAILED;
         
//        int randomRes = (int)(Math.random() * 6 + 1);
//        if(randomRes > 4){
//            return Response.status(Response.Status.OK).entity(SUCCESSFUL + " " + userID).build();
//        }
        return Response.status(Response.Status.OK).entity(result).build();
    }
    
    @PUT
    @Path("/editdetails")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editUserDetails(Customer cus){ 
        // temp Change to start at service
        String response = (new CustomerDaoImpl().updateCustomer(cus)) == true ? SUCCESSFUL : FAILED;
         
        return Response.status(Response.Status.OK).entity(response).build();
    }
    
    @GET
    @Path("/accounts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> retrieveAllUsers(){
        // ???? REturn users or customers -> spec says they should be able to view customers
        // regardless of whether theyre inactive or active
        ArrayList<Customer> arr = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++) {
            arr.add(new Customer((7777 + i),"larr","perth","email@gmail","0112112211","0118818881","9999999990221",1111,"password"));
        }
        // return new CustomerDaoImpl().getAll(); 
        return arr;
    }

    @GET
    @Path("/recover/{email}")
    public String recoverAccount(@PathParam("email") String customerEmail){
        
        String response = (new CustomerServiceImpl().confirmEmail(customerEmail)) == true ? SUCCESSFUL : FAILED;
        
        return response;
        //return "ATTEMPTED TO RECOVER";
    }
    
}
    
    
 
  