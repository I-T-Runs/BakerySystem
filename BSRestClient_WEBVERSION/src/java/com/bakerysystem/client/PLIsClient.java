/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.client;

import com.bakerysystem.model.ProductLineItem;
import com.bakerysystem.properties.BSConfig;
import java.util.ArrayList;

/**
 *
 * @author Themba
 */
public class PLIsClient {
    private final static String URL = new BSConfig().getURL("product-line-items");
    private DefaultClient<ProductLineItem> dc;
    
    
    public PLIsClient() {
            dc = new DefaultClient<>("content");        
    }
    
     public String addPLI(ProductLineItem admin){
        return dc.create(admin, "add");
    }
    
    public ProductLineItem getPLI(int userid) {
       return dc.get(userid, "a-pli/{id}");
    }
    
    public   String remove(int userId) {
        return dc.remove(userId, "remove");
    }
    
    public String editPLI(ProductLineItem cus) {
        return dc.update(cus, "edit");
    }

    public   ArrayList<ProductLineItem> getAllPLIs() {    
        return dc.getAll("all-plis");
    }
}
