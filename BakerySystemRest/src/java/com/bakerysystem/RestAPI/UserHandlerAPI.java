package com.bakerysystem.RestAPI;

import com.bakerysystem.Model.User;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Themba
 */

@Path("/users")
public class UserHandlerAPI {
    
    private final String SUCCESSFUL = "REGISTRATION WAS SUCCESSFUL";
    private final String FAILED = "REGISTRATION FAILED";
    
    @GET
    @Path("/login/{username}/{password}")
    public User signingInUser(@QueryParam("username") String username, @QueryParam("password") String password){
       User user = null; // new UserDaoImpl().getUser(username,password); 
       return user;
    }
    
    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON )
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerInUser(User user){//@FormParam("txtUsername") String username, @FormParam("txtEmail") String email , @FormParam("txtPassword") String password){
        // usertype automatically defaults to customer unless they pass in a certain string which is a secret password we'll use
        // to regester an admin
        
        
        //temp
        //String secretPass;
        if(user.getUserName().contains("iwanttobeadmin")){
            // make them an admin
        }else{
            //new UserDao().addUser(  REF User    or  username,email,password,"customer")
//            System.out.println("UN: " + user.getUserName() + "\nUP" + user.getEmail());

        }        
// User user = null; // new UserDaoImpl().getUser(username,password); 
        
       return Response.status(Response.Status.OK).entity("return customer").build();
    }
    
    @DELETE
    @Path("/deactivate")
    public Response deactivateUser(){
        // User user = null; // new UserDaoImpl().removeUser(username,password); 
        
        return Response.status(Response.Status.OK).entity(FAILED).build();
    }
    
    @PUT
    @Path("/edit")
    public boolean editUserDetails(){
        // User user = null; // new UserDaoImpl().updateUser(username,password); 
        
        return false;
    }
    
    @GET
    @Path("/populate")
    public List<User> retrieveAllUsers(){
        // ???? REturn users or customers -> spec says they should be able to view customers
        
        //  new UserDaoImpl().getUsers();
        return null;
    }
}
    
    
 
  