/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.Daos;

import com.bakerysystem.Model.User;
import java.util.ArrayList;

/**
 *
 * @author Themba
 */
public interface UsersDao {
    public User getUser(int userid);            
    public boolean removeUser(int userid);
    public boolean addUser();// 
    public User updateUser(int userid);
    public ArrayList<User> getUsers();
}
