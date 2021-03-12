/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.Service;

import com.bakerysystem.Daos.CartDao;
import com.bakerysystem.Daos.CartDaoImpl;
import com.bakerysystem.Daos.CustomerDao;
import com.bakerysystem.Daos.CustomerDaoImpl;
import com.bakerysystem.Daos.UserDao;
import com.bakerysystem.Daos.UserDaoImpl;
import com.bakerysystem.Model.Customer;
import com.bakerysystem.Model.User;

/**
 *
 * @author keoagile
 */
public class CustomerServiceImpl implements CustomerService{

    private CustomerDao custD;
    private UserDao ud;
    private CartDao cartD;
    
    public CustomerServiceImpl() {
       
        ud = new UserDaoImpl();
        custD = new CustomerDaoImpl();
        cartD = new CartDaoImpl();
    }
  
    @Override
    public Customer registerCustomer(Customer cust) {
        if(ud.getUser(cust.getEmail(), cust.getPassword()) != null){
            return null;
        }
        custD.addCustomer(cust);
        ud.addUser(new User(cust.getEmail(),cust.getPassword(),"CUSTOMER"));
        return cust;
    }

    @Override
    public Customer login(String email, String password) {
        Customer cust = custD.getCustomer(ud.getUser(email, password).getUserId());
        cust.setCart(cartD.getCart(cust.getCustomerId()));
        return cust;
    }

//    @Override
//    public boolean passwordRecovery(String email) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public boolean updateCustomer(Customer cust) {
        return custD.updateCustomer(cust);
    }
}
