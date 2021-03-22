/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.Daos;

import com.bakerysystem.Model.AddressClass;
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
public class AddressDaoImpl implements AddressDao{

    private Connection myCon7;
    private PreparedStatement ps;
    private ResultSet rs;
    private String URL;
    
    public AddressDaoImpl() {
    
         try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Failed to load JDBC/ODBC driver." + e.toString());
			e.printStackTrace();
		}
		
//		String url = "jdbc:mysql://localhost:3306/cakeshop";
                URL = "jdbc:mysql://"+new BSConfig().getDbhost()+":3306/cakeshop";
		try { 
                    //                                           created user [ initialise with BSConfig ]
			myCon7 = DriverManager.getConnection(URL,"mthiz","root");
		} catch (SQLException e) {
                    System.out.println("\n"+e.getMessage()+"\n");
			 try {
                URL = "jdbc:mysql://localhost:3306/cakeshop";
                myCon7 = DriverManager.getConnection(URL, "root", "root");
            } catch (SQLException ex) {
                ex.getMessage();
            }
		}
    }
    
    public static void main(String [] args){
        System.out.println(new AddressDaoImpl().URL);
    }

    
    
    @Override
    public AddressClass getAddress(int addressID) {
        try {
            //int addID, int houseNo, String strName, String suburb, String city, int postCode
            ps = myCon7.prepareStatement("SELECT ADDRESSID, HOUSENUMBER, STREETNAME, SUBURB, CITY, POSTCODE FROM ADDRESSTABLE WHERE ADDRESSID = ? AND ACTIVITY = ACTIVE");
            ps.setInt(1, addressID);
            rs = ps.executeQuery();
            
            while(rs.next()){
                return new AddressClass(rs.getInt("ADDRESSID"), rs.getInt("HOUSENUMBER"), rs.getString("STREETNAME"), rs.getString("SUBURB"), rs.getString("CITY"), rs.getInt("POSTCODE"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddressDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
     return null;   
    }

    @Override
    public boolean addAddress(AddressClass address) {
        int check = 0;
        try {
            ps = myCon7.prepareStatement("INSERT INTO ADDRESSTABLE(ADDRESSID, HOUSENUMBER, STREETNAME, SUBURB, CITY, POSTCODE, ACTIVITY) VALUES(null,?,?,?,?,?,'ACTIVE') ");
            ps.setInt(1, address.getHouseNumber());
            ps.setString(2, address.getStreetName());
            ps.setString(3, address.getSuburb());
            ps.setString(4, address.getCity());
            ps.setInt(5, address.getPostalCode());
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AddressDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (check == 1);
    }

    @Override
    public boolean removeAddress(int addressID) {
        int check = 0;
        
        try {
            ps = myCon7.prepareStatement("UPDATE ADDRESSTABLE SET ACTIVITY = 'INACTIVE' WHERE ADDRESSID = ?");
            ps.setInt(1, addressID);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AddressDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (check == 1);
    }

    @Override
    public boolean updateAddress(AddressClass address) {
        int check = 0;
        try {
            ps = myCon7.prepareStatement("UPDATE ADDRESSTABLE SET HOUSENEUMBER = ?, STREETNAME = ?, SUBURB = ?, CITY = ?, POSTCODE = ? WHERE ADDRESSID = ?");
            ps.setInt(1, address.getHouseNumber());
            ps.setString(2, address.getStreetName());
            ps.setString(3, address.getSuburb());
            ps.setString(4, address.getCity());
            ps.setInt(5, address.getPostalCode());
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AddressDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (check == 1);
    }

    @Override
    public ArrayList<AddressClass> getAllAddresses() {
        ArrayList<AddressClass> listOfAddresses = new ArrayList();
        
        try {
            ps = myCon7.prepareStatement("SELECT ADDRESSID, HOUSENUMBER, STREETNAME, SUBURB, CITY, POSTCODE FROM ADDRESSTABLE WHERE ACTIVITY = ACTIVE");
            rs = ps.executeQuery();
            
            if(rs == null){
                return null;
            }
            
            while(rs.next()){
                listOfAddresses.add(new AddressClass(rs.getInt("ADDRESSID"), rs.getInt("HOUSENUMBER"), rs.getString("STREETNAME"), rs.getString("SUBURB"), rs.getString("CITY"), rs.getInt("POSTCODE")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddressDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOfAddresses;
    }    
}
