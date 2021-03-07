
package com.bakerysystem.RestAPI;

import com.bakerysystem.Model.AddressClass;
import com.bakerysystem.Model.Ingredient;
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
public class AddressHandlerAPI {
    
       private final String SUCCESSFUL = "SUCCESSFUL!";
    private final String FAILED = "FAILED!";
 
    // ADDING A CATEGORY
    @POST
    @Path("/add-address")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addAddress(){
       
       
        // IF STATEMENT THAT WILL REPRESENT SUCCESSFUL CONDITION
       return FAILED;
    }
    
    @DELETE
    @Path("/delete")
    public String removeAddress(@PathParam("addressid") int addressID){
        
                
                // IF STATEMENT THAT WILL REPRESENT SUCCESSFUL CONDITION
        return FAILED;
    }
    
    @PUT
    @Path("/edit")
    public String editAddress(@PathParam("addressid") int addressID){ //
        return FAILED;
    }
    
    @GET
    @Path("/address-collection")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AddressClass> getAllAddresses(){
        
        // return ingredients;
        return null;
    }
    
    @GET
    @Path("/address-line")
    @Produces(MediaType.APPLICATION_JSON)
    public AddressClass getCustomerAddress(@PathParam("addressid") int addressID){
        
        // return new dao.getAddress(addressID);
        return null;
    }
    
}
