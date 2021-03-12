/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.Service;

import com.bakerysystem.Model.Customer;

/**
 *
 * @author keoagile
 */
public interface CustomerService {
    
    Customer registerCustomer(Customer cust);
    Customer login(String email, String password);
    //boolean passwordRecovery(String email);
    boolean updateCustomer(Customer cust);
    boolean confirmEmail(String email);
    
}
