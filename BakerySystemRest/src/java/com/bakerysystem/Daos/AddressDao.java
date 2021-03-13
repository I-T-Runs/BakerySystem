/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.Daos;

import com.bakerysystem.Model.AddressClass;
import java.util.ArrayList;
/**
 *
 * @author keoagile
 */
public interface AddressDao {
    
    AddressClass getAddress(int addressID);
    boolean addAddress(AddressClass address);
    boolean removeAddress(int addressID);
    boolean updateAddress(AddressClass address);
    ArrayList<AddressClass> getAllAddresses();
    
}
