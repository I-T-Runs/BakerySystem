/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.Daos;

import com.bakerysystem.Model.Category;
import java.util.ArrayList;

/**
 *
 * @author Themba
 */
public interface CategoryDao {
    public Category getCategory(int productId);            
    public boolean removeCategory(int productId);
    public boolean addCategory();// 
    public Category updateCategory(int productId);
    public ArrayList<Category> getProducts();              
}
