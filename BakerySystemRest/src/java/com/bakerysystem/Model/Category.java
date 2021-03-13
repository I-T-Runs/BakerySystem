package com.bakerysystem.Model;

import java.util.ArrayList;

public class Category {

    //Attributes
    private int categoryID;
    private String categoryName ; 
    private ArrayList<Product> productList;

    public Category(int catID, String catName) {
        setCategoryID(catID);
        setCategoryName(catName);
    }
    
    
    //Acessors/Mutators
    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
        
}
