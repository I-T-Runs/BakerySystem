/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.client;

import Model.Ingredient;
import com.bakerysystem.properties.BSConfig;
import java.util.ArrayList;

/**
 *
 * @author Themba
 */
public class IngredientsClient {
    
    private final static String URL = new BSConfig().getURL("stock");
    private DefaultClient<Ingredient> dc;
    
    
    public IngredientsClient() {
            dc = new DefaultClient<>("ingrediants");        
    }
    
     public String addIngredient(Ingredient admin){
        return dc.create(admin, "add");
    }
    
    public Ingredient getIngredient(int userid) {
       return dc.get(userid, "ingredient/{id}");
    }
    
    public   String remove(int userId) {
        return dc.remove(userId, "remove");
    }
    
    public String updateDetails(Ingredient cus) {
        return dc.update(cus, "edit");
    }

    public   ArrayList<Ingredient> getAllIngredients() {    
        return dc.getAll("ingredients");
    }
}
