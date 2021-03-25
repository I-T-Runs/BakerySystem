/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.Services;

import com.bakerysystem.Model.Product;
import com.bakerysystem.dao.ProductDao;
import com.bakerysystem.dao.ProductDaoImpl;
import java.util.ArrayList;

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
    public ArrayList<Product> getProducts() {
        return pdl.getProducts();
    }

    @Override
    public Product getProduct(int productId) {
        return pdl.getProduct(productId);
    }

    @Override
    public boolean addProduct(Product product) {
        return pdl.addProduct(product);
    }

    @Override
    public boolean removeProduct(int productId) {
        return pdl.removeProduct(productId);
    }

    @Override
    public boolean updateProduct(Product prod) {
        return pdl.updateProduct(prod);
    }

}
