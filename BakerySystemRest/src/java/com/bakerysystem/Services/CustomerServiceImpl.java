/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.Services;

import com.bakerysystem.Daos.CartDao;
import com.bakerysystem.Daos.CartDaoImpl;
import com.bakerysystem.Daos.CustomerDao;
import com.bakerysystem.Daos.CustomerDaoImpl;
import com.bakerysystem.Daos.UserDao;
import com.bakerysystem.Daos.UserDaoImpl;
import com.bakerysystem.Model.Customer;
import com.bakerysystem.Model.User;
import java.util.ArrayList;

/**
 *
 * @author keoagile
 */
public class CustomerServiceImpl implements CustomerService {

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
        if (ud.getUser(cust.getEmail(), cust.getPassword()) != null) {
            return null;
        }
        custD.addCustomer(cust);
        ud.addUser(new User(cust.getEmail(), cust.getPassword(), "CUSTOMER"));
        return cust;
    }

    public static void main(String[] args) {
        Customer c = new CustomerServiceImpl().registerCustomer(new Customer("larr" + 0, "perth" + 0, "email@gmail", "0112112211", "0118818881", "1111111" + (102210 + 0) + "", 1111, "password"));
        System.out.println(c.getFirstName());
    }

    @Override
    public Customer login(String email, String password) {
        Customer cust = custD.getCustomer(ud.getUser(email, password).getUserId());
        
        // Alright so cart is being initialised we can say
        // - if it contains items, then we are 
//             supposed to get those else its empty
//         
        cust.setCart(cartD.getCart(cust.getCustomerId()));
        return cust;
    }

    @Override
    public boolean updateCustomer(Customer cust) {
        return custD.updateCustomer(cust);
    }

    @Override
    public boolean confirmEmail(String email) {
        if (custD.getCustomerEmail(email) == null) {
            return false;
        }
        ud.updatePassword(email, custD.generateOtp(email));
        return true;
    }

    @Override
    public ArrayList<Customer> getAllCustomers() {
        return custD.getAllCustomers();
    }

    @Override
    public Customer getCustomer(int customerId) {
        return custD.getCustomer(customerId);
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        return custD.removeCustomer(customerId);
    }
}
