/** To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.Services;

import com.bakerysystem.Daos.CartDaoImpl;
import com.bakerysystem.Model.Cart;

/**
 *
 * @author Themba
 */
public class CartServiceImpl implements CartService {

    private final String SUCCESSFUL = "SUCCESSFUL!";
    private final String FAILED = "FAILED!";
    
    @Override
    public String addToCart(Cart cart) {
       if(new CartDaoImpl().addCart(cart) == true){
           return SUCCESSFUL;
       }
       return FAILED;   
    }

    @Override
    public Cart getCart(int userid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override           // update items within cart
    public String updateCart(Cart cart) {
        if(new CartDaoImpl().updateCart(cart) == true){
           return SUCCESSFUL;
       }
       return FAILED; 
    }
    
//    @Override
//    public String removeFromCart(int cartid) {
//       if(new CartDaoImpl().removeFromCart(cart) == true){
//           return SUCCESSFUL;
//       }
//       return FAILED; 
//    }

    

   
    
}
