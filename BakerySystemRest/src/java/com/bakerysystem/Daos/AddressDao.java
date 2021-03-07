
package com.bakerysystem.Daos;

import com.bakerysystem.Model.AddressClass;
/**
 *
 * @author keoagile
 */
public interface AddressDao {
    
    // cant be getting all the addresses though
    // public List<AddressClass> getAllAddresses();
    public AddressClass getAddress(int addressID);
    public void addCustomerAddress(AddressClass address);
    public boolean removeAddress(int addressID);
    public boolean editAddress(int addressID);
    
}
