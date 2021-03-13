
import com.tempbakery.coreclasses.Ingredient;
import com.tempbakery.coreclasses.Product;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/resources")
public class ProductsFacadeAPI {

    @Path("/product/{productid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Product getItem(@PathParam("productid") int productid){

        ArrayList<Product> catalogue = new ArrayList<>();
        ArrayList<Ingredient> recipe = new ArrayList<Ingredient>();
        for (int i = 0; i < 3; i++) {
            recipe.add(new Ingredient(((i + 1)), ("ingredient" + (i + 1)), (((int) (Math.random() * 6) + 1))));
        }

        Product p = null;
        // capture a product
        for (int i = 0; i < 10; i++) {
            p = new Product(110320 + i, "Donnut" + i, null, recipe, 0);
            catalogue.add(p);
        	if(p.getProductID() == productid){
        		return p;
        	}
        }

        //110321
        return null;//new Product(110321, "Donnut" + 1, null, recipe, 0);
    }
}
