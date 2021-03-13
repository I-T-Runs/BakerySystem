package com.bakerysystem.Daos;

import com.bakerysystem.Model.Product;
import java.util.ArrayList;
//import com.bakerysystem.Model.User;

/**
 * @author Themba
 */
public interface ProductDao {
    public Product getProduct(int productId);             // 
//    public boolean removeProduct(int productId);
    public boolean addProduct(Product prod);// 
//    public Product updateProduct(int productId);          // we're gonna use this for adding ingredients and 
//    public ArrayList<Product> getProducts();              // return array 
//    public Product getProductByCategory(int productId);   // plain get by category
//    public Product searchForProduct(String searchString); // the select where piece of text is something sql
}
