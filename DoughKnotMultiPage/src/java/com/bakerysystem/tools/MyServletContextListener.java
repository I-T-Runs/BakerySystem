/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.tools;

import com.bakerysystem.Model.Product;
import com.bakerysystem.client.ProductsClient;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author David
 */
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
//        ArrayList<Product> prodArr = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            prodArr.add(new Product("s", "s", "s", "s", 1.1, 1, 1));
//        }

        ArrayList<Product> prodArr = (ArrayList<Product>) new ProductsClient().recieveProducts();
        sc.setAttribute("ProductArr", prodArr);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
