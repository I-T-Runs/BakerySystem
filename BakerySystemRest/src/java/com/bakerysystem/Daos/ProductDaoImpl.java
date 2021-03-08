/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.Daos;

import com.bakerysystem.Model.Ingredient;
import com.bakerysystem.Model.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author keoagile
 */

public class ProductDaoImpl implements ProductDao {

    private Connection myCon;
    private PreparedStatement ps;
    private ResultSet rs;
    private ResultSet rs2;

    public ProductDaoImpl() {
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Failed to load JDBC/ODBC driver." + e.toString());
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/cakeshop";
		try {
			myCon = DriverManager.getConnection(url,"root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @Override
    public boolean addProduct(Product prod) {
      
        int check =0;
        
        try {
            ps = myCon.prepareStatement("INSERT INTO PRODUCTSTABLE(PRODUCTID, CATEGORYID, PRODUCTNAME, PRICE, DISCOUNT, PHOTO, PRODUCTDESCRIPTION, PRODUCTWARNINGS, ACTIVITY) VALUES(null,?,?,?,?,?,?,?, 'ACTIVE')");
           
            ps.setInt(1, prod.getCategoryID());
            ps.setString(2, prod.getProductName());
            ps.setDouble(3, prod.getPrice());
            ps.setInt(4, prod.getDiscount());
            ps.setString(5, prod.getPhoto());
            ps.setString(6, prod.getProductDescription());
            ps.setString(7, prod.getProductWarnings());
            check = ps.executeUpdate();
            
            if(check != 1){
                return false;
            }
    
            for (int i = 0; i < prod.getRecipeArr().size(); i++ ) {
                ps = myCon.prepareStatement("INSERT INTO PRODUCTINGREDIENTTABLE(PRODUCTID, INGREDIENTID, QUANTITY) VALUES(?,?,?)");
                ps.setInt(1, prod.getProductID());
                ps.setInt(2, prod.getRecipeArr().get(i).getIngredientId());
                ps.setInt(3, prod.getRecipeArr().get(i).getQuantity());
                ps.executeUpdate();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return true;
    }

    @Override
    public Product getProduct(int productId) {
        ArrayList<Ingredient>ingrs = new ArrayList();
        Product prd = null;
        try {
            
            
            ps = myCon.prepareStatement("SELECT PRODUCTINGREDIENTTABLE.INGREDIENTID, PRODUCTINGREDIENTTABLE.QUANTITY, INGREDIENTTABLE.NAME FROM INGREDIENTTABLE INNNER JOIN PRODUCTINGREDIENTTABLE WHERE PRODUCTINGREDIENTTABLE.PRODUCTID = ? AND PRODUCTINGREDIENTTABLE.INGREDIENTID = INGREDIENTTABLE.INGREDIENTID");
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                ingrs.add(new Ingredient(rs.getInt("INGREDIENTTABLE"), rs.getString("NAME"), rs.getInt("QUANTITY")));
            }
            
            ps = myCon.prepareStatement("SELECT PRODUCTID, CATEGORYID, PRODUCTNAME, PRICE, DISCOUNT, PHOTO, PRODUCTDESCRIPTION, PRODUCTWARNINGS FROM PRODUCTSTABLE WHERE PRODUCTID = ? AND ACTIVITY = 'ACTIVE'");
            rs = ps.executeQuery();
                    
            while(rs.next()){
                prd = new Product(rs.getInt("PRODUCTID"), rs.getString("PRODUCTNAME"), rs.getString("PHOTO"), rs.getInt("CATEGORYID"), rs.getDouble("PRICE"), rs.getInt("DISCOUNT"), ingrs, rs.getString("PRODUCTDESCRIPTION"), rs.getString("PRODUCTWARNINGS"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prd;
    }

    @Override
    public boolean removeProduct(int productId) {
           int check =0;
        try {
            ps = myCon.prepareStatement("UPDATE PRODUCTSTABLE SET ACTIVITY = 'INACTIVE' WHERE PRODUCTID = ?");
            check = ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (check == 1);
    }

    @Override
    public ArrayList<Product> getProducts() {
        ArrayList<Product>listOfProducts = new ArrayList();
        ArrayList<Ingredient>recipe = new ArrayList();
        
        try {
            ps = myCon.prepareStatement("SELECT PRODUCTID, CATEGORYID, PRODUCTNAME, PRICE, DISCOUNT, PHOTO, PRODUCTDESCRIPTION, PRODUCTWARNINGS FROM PRODUCTSTABLE WHERE ACTIVITY = 'ACTIVE'");
            rs = ps.executeQuery();
            
            while(rs.next()){   
                 ps = myCon.prepareStatement("SELECT PRODUCTINGREDIENTTABLE.INGREDIENTID, PRODUCTINGREDIENTTABLE.QUANTITY, INGREDIENTTABLE.NAME FROM INGREDIENTTABLE INNNER JOIN PRODUCTINGREDIENTTABLE WHERE PRODUCTINGREDIENTTABLE.PRODUCTID = ? AND PRODUCTINGREDIENTTABLE.INGREDIENTID = INGREDIENTTABLE.INGREDIENTID");
                 ps.setInt(1, rs.getInt("PRODUCTID"));
                 rs2 = ps.executeQuery();
                 
                 while(rs2.next()){
                     
                     recipe.add(new Ingredient(rs2.getInt("INGREDIENTTABLE"), rs2.getString("NAME"), rs2.getInt("QUANTITY")));
                 }
              listOfProducts.add(new Product(rs.getInt("PRODUCTID"), rs.getString("PRODUCTNAME"), rs.getString("PHOTO"), rs.getInt("CATEGORYID"), rs.getDouble("PRICE"), rs.getInt("DISCOUNT"), recipe, rs.getString("PRODUCTDESCRIPTION"), rs.getString("PRODUCTWARNINGS")));
              recipe.clear();
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return listOfProducts;
    }

    @Override
    public ArrayList<Product> searchForProduct(String searchString) {
        
        ArrayList<Product>searchResult = new ArrayList();
        ArrayList<Ingredient>recipe = new ArrayList();
        
        try {
            ps = myCon.prepareStatement("SELECT PRODUCTID, CATEGORYID, PRODUCTNAME, PRICE, DISCOUNT, PHOTO, PRODUCTDESCRIPTION, PRODUCTWARNINGS FROM PRODUCTSTABLE WHERE PRODUCTNAME LIKE '%?%' AND ACTIVITY = 'ACTIVE'");
            ps.setString(1, searchString);
            rs = ps.executeQuery();
            
            while(rs.next()){   
                 ps = myCon.prepareStatement("SELECT PRODUCTINGREDIENTTABLE.INGREDIENTID, PRODUCTINGREDIENTTABLE.QUANTITY, INGREDIENTTABLE.NAME FROM INGREDIENTTABLE INNNER JOIN PRODUCTINGREDIENTTABLE WHERE PRODUCTINGREDIENTTABLE.PRODUCTID = ? AND PRODUCTINGREDIENTTABLE.INGREDIENTID = INGREDIENTTABLE.INGREDIENTID");
                 ps.setInt(1, rs.getInt("PRODUCTID"));
                 rs2 = ps.executeQuery();
                 
                 while(rs2.next()){
                     
                     recipe.add(new Ingredient(rs2.getInt("INGREDIENTTABLE"), rs2.getString("NAME"), rs2.getInt("QUANTITY")));
                 }
              searchResult.add(new Product(rs.getInt("PRODUCTID"), rs.getString("PRODUCTNAME"), rs.getString("PHOTO"), rs.getInt("CATEGORYID"), rs.getDouble("PRICE"), rs.getInt("DISCOUNT"), recipe, rs.getString("PRODUCTDESCRIPTION"), rs.getString("PRODUCTWARNINGS")));
              recipe.clear();
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return searchResult;
    }

    @Override
    public boolean updateProduct(Product prod) {
        int check;
        try {
            ps = myCon.prepareStatement("UPDATE PRODUCTTABLE SET PRODUCTNAME = ?, PHOTO = ?, PRODUCTDESCRIPTION = ?, PRODUCTWARNINGS = ?, PRICE = ?, DISCOUNT = ?, CATEGORYID = ? WHERE PRODUCTID = ? ");
            ps.setString(1, prod.getProductName());
            ps.setString(2, prod.getPhoto());
            ps.setString(3, prod.getProductWarnings());
            ps.setDouble(4, prod.getPrice());
            ps.setInt(5, prod.getDiscount());
            ps.setInt(6, prod.getCategoryID());
            check = ps.executeUpdate();
            if(check != 1){
                return false;
            }
            for(int i =0; i < prod.getRecipeArr().size(); i++){
            
                ps = myCon.prepareStatement("UPDATE PRODUCTINGREDIENTTABLE SET INGREDIENTID = ?, QUANTITY = ? WHERE PRODUCTID = ?");
                ps.setInt(1, prod.getRecipeArr().get(i).getIngredientId());
                ps.setInt(2, prod.getRecipeArr().get(i).getQuantity());
                ps.setInt(3, prod.getProductID());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;   
    }
}
 