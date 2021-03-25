/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.Services;

import com.bakerysystem.Model.Product;
import java.util.ArrayList;

/**
 *
 * @author keoagile
 */
public interface ProductService {
    
    ArrayList<Product> getProducts();
    Product getProduct(int productId);
     boolean addProduct(Product product);
    public boolean removeProduct(int productId);
    public boolean updateProduct(Product prod);     
}
