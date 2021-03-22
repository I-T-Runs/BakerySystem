/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.Daos;

import com.bakerysystem.Model.Cart;
import com.bakerysystem.Model.ProductLineItem;
import com.bakerysystem.properties.BSConfig;
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
		
//		String url = "jdbc:mysql://localhost:3306/cakeshop";
                String URL = "jdbc:mysql://"+new BSConfig().getDbhost()+":3306/cakeshop";
		try { 
                    //                                           created user [ initialise with BSConfig ]
			myCon10 = DriverManager.getConnection(URL,"mthiz","root");
		} catch (SQLException e) {
                    System.out.println("\n"+e.getMessage()+"\n");
			 try {
                URL = "jdbc:mysql://localhost:3306/cakeshop";
                myCon10 = DriverManager.getConnection(URL, "root", "root");
            } catch (SQLException ex) {
                ex.getMessage();
            }
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
       Cart c = new Cart();
       ArrayList<ProductLineItem> prods =new ArrayList();
        try {
            //ps = myCon10.prepareStatement("SELECT CARTID, PRODUCTID, PRODUCTNAME, QUANTITY WHERE CUSTOMERID = ? AND ACTIVITY = 'ACTIVE'");
            ps = myCon10.prepareStatement("SELECT PRODUCTID, QUANTITY FROM CARTTABLE WHERE CUSTOMERID = ?");

            ps.setInt(1, customerID);
            rs = ps.executeQuery();
     
            while(rs.next()){
                int prodID = rs.getInt("PRODUCTID");
                String pliName = new ProductDaoImpl().getProduct(prodID).getProductName();
                int qnty = rs.getInt("QUANTITY");
                prods.add(new ProductLineItem(prodID, pliName,qnty));
            }
            if(!prods.isEmpty()){                
                c.setProducts(prods);
                return c;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }       
        c.setProducts(null);
        return c;
    }
    
    public static void main(String [] args){
           
        Cart c = new CartDaoImpl().getCart(1);
        for (ProductLineItem product : c.getProducts()) {
             System.out.println("Product\t" + " | " + "Quantity");
             System.out.println(product.getProductName() + " | " + product.getQuantity());
        }
    }

    public boolean updateCart(Cart cart) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
