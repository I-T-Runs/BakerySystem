/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.dao;

import com.bakerysystem.Model.Product;
import java.util.ArrayList;

/**
 *
 * @author keoagile
 */
public interface ProductDao {
    boolean addProduct(Product product);
    ArrayList<Product> getProducts();
}
