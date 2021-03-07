/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.RestAPI;

import com.bakerysystem.Model.User;
import java.util.List;
import javax.ws.rs.*;

/**
 *
 * @author Themba
 */

@Path("/users")
public class UserHandlerAPI {
    
    @GET
    @Path("/login")
    public User signingInUser(@FormParam("txtUsername") String username, @FormParam("txtPassword") String password){
       User user = null; // new UserDaoImpl().getUser(username,password); 
       return user;
    }
    
    @POST
    @Path("/signup")
    public boolean registerInUser(@FormParam("txtUsername") String username, @FormParam("txtEmail") String email , @FormParam("txtPassword") String password){
        // usertype automatically defaults to customer unless they pass in a certain string which is a secret password we'll use
        // to regester an admin
        
        //temp
        //String secretPass;
        if(username.contains("iwanttobeadmin")){
            // make them an admin
        }else{
            //new UserDao().addUser(  REF User    or  username,email,password,"customer")
        }
        

// User user = null; // new UserDaoImpl().getUser(username,password); 
        
       return false;
    }
    
    @DELETE
    @Path("/deactivate")
    public boolean deactivateUser(){
        // User user = null; // new UserDaoImpl().removeUser(username,password); 
        
        return false;
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
    
    
 
  