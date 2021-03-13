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

    
    private Connection myCon10;
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
			myCon10 = DriverManager.getConnection(url,"root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    
    }

    @Override
    public boolean addCart(Cart cart) {
        int check = 0;
        
        try {
            for(int i =0; i <cart.getProducts().size(); i++){
            ps = myCon10.prepareStatement("INSERT INTO CARTTABLE(CARTID,CUSTOMERID,PRODUCTID,QUANTITY,ACTIVITY) VALUES(NULL,?,?,?,'ACTIVE')");
            ps.setInt(1, cart.getCustomerId());
            ps.setInt(2, cart.getProducts().get(i).getProductID());
            ps.setInt(3, cart.getProducts().get(i).getQuantity());
            check = ps.executeUpdate() + check; 
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (check == cart.getProducts().size());
    }

    @Override
    public Cart getCart(int customerID) {
       int cartId = 0;
       ArrayList<ProductLineItem> prods =new ArrayList();
       
        try {
<<<<<<< HEAD
            //ps = myCon10.prepareStatement("SELECT CARTID, PRODUCTID, PRODUCTNAME, QUANTITY WHERE CUSTOMERID = ? AND ACTIVITY = 'ACTIVE'");
            ps = myCon10.prepareStatement("SELECT CARTID, PRODUCTID, QUANTITY FROM CARTTABLE WHERE CUSTOMERID = ? AND ACTIVITY = 'ACTIVE'");
=======
            ps = myCon10.prepareStatement("SELECT CARTID, PRODUCTID, PRODUCTNAME, QUANTITY WHERE CUSTOMERID = ? AND WHERE ACTIVITY = 'ACTIVE'");
>>>>>>> 92fa375293901d518580bad559895f784aa0e400
            ps.setInt(1, customerID);
            rs = ps.executeQuery();
     
            while(rs.next()){
                cartId = rs.getInt("CARTID");
                prods.add(new ProductLineItem(rs.getInt("PRODUCTID"), rs.getString("PRODUCTNAME"), rs.getInt("QUANTITY")));
            }
            if(!prods.isEmpty()){
                
                return new Cart(customerID, prods, cartId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return new Cart(customerID,cartId);
    }
}
