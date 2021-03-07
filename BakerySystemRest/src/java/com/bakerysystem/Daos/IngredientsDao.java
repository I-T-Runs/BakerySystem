/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.Daos;

import com.bakerysystem.Model.Ingredient;
import java.util.ArrayList;

/**
 *
 * @author Themba
 */
public interface IngredientsDao {
    public ArrayList<Ingredient> getIngredients();
    public Ingredient getIngredient(int ingredientid);            
    public boolean removeIngredient(int ingredientid);
    public boolean addIngredient();// 
    public Ingredient updateIngredient(int userid);
}
