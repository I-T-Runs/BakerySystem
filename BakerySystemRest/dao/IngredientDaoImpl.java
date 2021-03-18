/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.dao;

import com.bakerysystem.Model.Ingredient;
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
public class IngredientDaoImpl implements IngredientDao{

     private Connection myCon2;
    private PreparedStatement ps;
    private ResultSet rs;
   

    public IngredientDaoImpl() {
    
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Failed to load JDBC/ODBC driver." + e.toString());
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/cakeshop";
		try {
			myCon2 = DriverManager.getConnection(url,"root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    @Override
    public Ingredient getIngredient(int ingredientId) {
         try {
             ps = myCon2.prepareStatement("SELECT INGREDIENTID, INGREDIENTNAME, QUANTITY FROM INGREDIENTTABLE WHERE INGREDIENTID = ? AND ACTIVITY = 'ACTIVE'");
             ps.setInt(1, ingredientId);
             rs = ps.executeQuery();
             
             while(rs.next()){
                 return new Ingredient(rs.getInt("INGREDIENTID"), rs.getString("INGREDIENTNAME"), rs.getInt("QUANTITY"));
             }
         } catch (SQLException ex) {
             Logger.getLogger(IngredientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }

    @Override
    public boolean addIngredient(Ingredient ingredient) {
        int check = 0;
        try {
            ps = myCon2.prepareStatement("INSERT INTO INGREDIENTTABLE(INGREDIENTID,INGREDIENTNAME,QUANTITY,ACTIVITY) VALUES(null,?,?,'ACTIVE')");
            ps.setString(1, ingredient.getIngredientName());
            ps.setInt(2, ingredient.getQuantity());
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(IngredientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (check == 1);
    }

    @Override
    public boolean updateIngredient(Ingredient ingredient) {
        int check = 0;
        
        try {
            ps = myCon2.prepareStatement("UPDATE INGREDIENTTABLE SET INGREDIENTNAME = ?, QUANTITY = ? WHERE INGREDIENTID = ?");
            ps.setString(1, ingredient.getIngredientName());
            ps.setInt(2, ingredient.getQuantity());
            ps.setInt(3, ingredient.getIngredientId());
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(IngredientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (check == 1);
    }

    @Override
    public boolean removeIngredient(int ingredientID) {
        int check =0;
        try {
            ps = myCon2.prepareStatement("UPDATE INGREDIENTTABLE SET ACTIVITY = 'INACTIVE' WHERE INGREDIENTID = ?");
            ps.setInt(1, ingredientID);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(IngredientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (check == 1);
    }

    @Override
    public ArrayList<Ingredient> getAllIngredients() {
        ArrayList<Ingredient>listOfIngredients = new ArrayList();
        
        try {
            ps = myCon2.prepareStatement("SELECT INGREDIENTID, INGREDIENTNAME, QUANTITY FROM INGREDIENTTABLE WHERE ACTIVITY = 'ACTIVE'");
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                listOfIngredients.add(new Ingredient(rs.getInt("INGREDIENTID"), rs.getString("INGREDIENTNAME"), rs.getInt("QUANTITY")));
            }    
        } catch (SQLException ex) {
            Logger.getLogger(IngredientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOfIngredients;
    }
    
}
