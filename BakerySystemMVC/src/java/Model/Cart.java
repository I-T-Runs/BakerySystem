package Model;

import java.util.ArrayList;

public class Cart {

    private int cartId;
    private ArrayList<ProductLineItem> products;

    @Override
    public String toString() {
        return "Cart [cartId=" + cartId + ", products=" + products + " ]";
    }

    public Cart(int cartId, ArrayList<ProductLineItem> products) {
        super();
        this.cartId = cartId;
        this.products = products;
    }

    public Cart() {
    }
    
    public void addToCart(Product p){
        ProductLineItem pli = produceProductLineItem(p);
        products.add(pli);
    }
    
    public ProductLineItem produceProductLineItem(Product product){
        ProductLineItem pli = new ProductLineItem();
        for (ProductLineItem p : products) {
            product = p;
        }
        return null;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setProducts(ArrayList<ProductLineItem> products) {
        this.products = products;
    }

    public int getCartId() {
        return cartId;
    }

    public ArrayList<ProductLineItem> getProducts() {
        return products;
    }

}
