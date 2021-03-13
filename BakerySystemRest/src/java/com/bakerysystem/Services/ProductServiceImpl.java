/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.Services;

import com.bakerysystem.Daos.ProductDao;
import com.bakerysystem.Daos.ProductDaoImpl;
import com.bakerysystem.Model.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author keoagile
 */
public class ProductServiceImpl implements ProductService {

    
    ProductDao pdl;

    public ProductServiceImpl() {
        pdl = new ProductDaoImpl();
    }
    
    @Override
    public ArrayList<Product> getAllProducts() {
        return pdl.getProducts();
    }

    @Override
    public Product getProduct(int productId) {
        return pdl.getProduct(productId);
    }

    @Override
    public ArrayList<Product> getProductsByCategory(int categoryId) {
        return pdl.getProductByCategory(categoryId);
    }

  
}
