package com.bakerysystem.Daos;

import com.bakerysystem.Model.Product;
import java.util.ArrayList;

/**
 * @author Themba
 */
public interface ProductDao {
    public Product getProduct(int productId);             
    public boolean removeProduct(int productId);
    public boolean addProduct(Product prod);
    public boolean updateProduct(Product prod);         // we're 
    public ArrayList<Product> getProducts();              // return array 
    public ArrayList<Product> getProductsByCategory(int categoryId); // plain get by category
    public ArrayList<Product> searchForProduct(String searchString); // the select where piece of text is something sql
}
