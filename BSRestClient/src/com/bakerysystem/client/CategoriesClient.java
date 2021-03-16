package com.bakerysystem.client;




import Model.AddressClass;
import Model.Category;
import Model.Product;
import com.bakerysystem.properties.BSConfig;
import java.util.ArrayList;

/**
 *
 * @author Themba
 */
public class CategoriesClient {
    private final static String URL = new BSConfig().getURL("categories");
    private DefaultClient<Category> dc;
    
    
    public CategoriesClient() {
            dc = new DefaultClient<>("content");        
    }
    
     public String addCategory(Category admin){
        return dc.create(admin, "add");
    }
    
    public Category getCategory(int userid) {
       return dc.get(userid, "a-category/{id}");
    }
    
    public   String remove(int userId) {
        return dc.remove(userId, "remove");
    }
    
    public String updateDetails(Category cus) {
        return dc.update(cus, "edit");
    }

    public   ArrayList<Category> getAllCategories() {    
        return dc.getAll("all-categories");
    }
}
