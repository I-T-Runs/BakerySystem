/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.Daos;

import com.bakerysystem.Model.Cart;
import com.bakerysystem.Model.ProductLineItem;
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
public class CartDaoImpl implements CartDao {

    
    private Connection myCon4;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CartDaoImpl() {
    
                try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Failed to load JDBC/ODBC driver." + e.toString());
			e.printStackTrace();
		}
	
		String url = "jdbc:mysql://localhost:3306/cakeshop";
		try {
			myCon4 = DriverManager.getConnection(url,"root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    
    }
    
    @Override
    public Cart getCart(int cartID) {
        ArrayList<ProductLineItem> products = new ArrayList();
        Cart cart;
        try {
            ps = myCon4.prepareStatement("SELECT PRODUCTID, PRODUCTNAME, QUANTITY FROM CARTTABLE WHERE CARTID = ?");
            ps.setInt(1, cartID);
            rs = ps.executeQuery();
            
            while(rs.next()){
                products.add(new ProductLineItem(rs.getInt("PRODUCTID"), rs.getString("PRODUCTNAME"), rs.getInt("QUANTITY")));
            }  
        } catch (SQLException ex) {
            Logger.getLogger(CartDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new Cart(cartID, products);
    }

    @Override
    public boolean addCart(Cart cart) {
        int check = 0;
        
        try {
            ps = myCon4.prepareStatement("INSER INTO CARTTABLE(CART)");
        } catch (SQLException ex) {
            Logger.getLogger(CartDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (check == 1);
    }
    
}
