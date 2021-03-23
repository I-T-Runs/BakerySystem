/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.dao;

import com.bakerysystem.Model.Ingredient;
import com.bakerysystem.databaseAccess.DBManager;
import java.sql.Connection;
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
            myCon2 = DBManager.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(IngredientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    @Override
    public boolean reduceIngredients(ArrayList<Ingredient> recipe , int quantity) {
       int check = 0;
         try {
             for(Ingredient ing: recipe){
               ps = myCon2.prepareStatement("UPDATE INGREDIENTABLE SET QUANTITY = (QUANTITY - ?) WHERE INGREDIENTID = ?");
               ps.setInt(1, (ing.getQuantity()*quantity));
               ps.setInt(2, ing.getIngredientId());
               check = ps.executeUpdate();
             }
         } catch (SQLException ex) {
             Logger.getLogger(IngredientDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
             closeStreams();
         }
         return (check > 1);
    }
    
        private synchronized void closeStreams() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (myCon2!= null) {
            try {
                myCon2.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
