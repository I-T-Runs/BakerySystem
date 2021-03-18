/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.client;

import com.bakerysystem.model.AddressClass;
import com.bakerysystem.properties.BSConfig;
import java.util.ArrayList;

/**
 *
 * @author Themba
 */
public class AddressesClient {
     private final static String URL = new BSConfig().getURL("addresses");
    private DefaultClient<AddressClass> dc;
    
    
    public AddressesClient() {
            dc = new DefaultClient<>("content");        
    }
    
     public String addAdmin(AddressClass admin){
        return dc.create(admin, "add");
    }
    
    public AddressClass getAccount(int userid) {
       return dc.get(userid, "ingredient/{id}");
    }
    
    public   String remove(int userId) {
        return dc.remove(userId, "remove");
    }
    
    public String updateDetails(AddressClass cus) {
        return dc.update(cus, "edit");
    }

    public   ArrayList<AddressClass> getAllAccounts() {    
        return dc.getAll("ingredients");
    }
}
