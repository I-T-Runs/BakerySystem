/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.Services;

import com.bakerysystem.Model.Ingredient;
import com.bakerysystem.dao.IngredientDao;
import com.bakerysystem.dao.IngredientDaoImpl;
import java.util.ArrayList;

/**
 *
 * @author keoagile
 */
public class IngredientServiceImpl implements IngredientService {

    IngredientDao ingrDao;

    public IngredientServiceImpl() {
        ingrDao = new IngredientDaoImpl();
    }
 
    
    @Override
    public Ingredient getIngredient(int ingredientId) {
        return ingrDao.getIngredient(ingredientId);
    }

    @Override
    public boolean addIngredient(Ingredient ingredient) {
        return ingrDao.addIngredient(ingredient);
    }

    @Override
    public boolean deleteIngredient(int ingredientId) {
        return ingrDao.removeIngredient(ingredientId);
    }

    @Override
    public boolean updateIngredient(Ingredient ingredient) {
        return ingrDao.updateIngredient(ingredient);
    }

    @Override
    public ArrayList<Ingredient> getAllIngredients() {
        return ingrDao.getAllIngredients();
    }
    
}
