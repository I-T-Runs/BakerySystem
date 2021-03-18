package com.bakerysystem.client;

import com.bakerysystem.model.Category;
import com.bakerysystem.model.Product;
import com.bakerysystem.extraz.Helper;
import com.bakerysystem.properties.BSConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Themba
 */
public class ProductsClient {

    private final static String URL = new BSConfig().getURL("shop");
    private DefaultClient<Product> dc;

    public ProductsClient() {
        dc = new DefaultClient<>("products");
    }

    public String addCategory(Product prod) {
        return dc.create(prod, "add");
    }

    public Product getProduct(int prodid) {
        return dc.get(prodid, "product/{id}");
    }

    public String remove(int prodId) {
        return dc.remove(prodId, "remove");
    }

    public String updateDetails(Product prod) {
        return dc.update(prod, "edit");
    }

    public ArrayList<Product> getAllProducts() {
        return dc.getAll("all-products");
    }
    
    public static void main(String [] args){
        System.out.println(URL);
    }

    // CSS - URL
    // URL(52.233.233:doata/images/j.jpg
}
