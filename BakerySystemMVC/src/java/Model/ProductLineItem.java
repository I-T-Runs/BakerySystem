package Model;

public class ProductLineItem extends Product {

    private int productID;
    private String productName;
    private int quantity;

    public ProductLineItem() {
    }

    public ProductLineItem(int productID, String productName, int quantity) {
        super();
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "ProductLineItem [productID=" + productID + ", productName=" + productName + ", quantity=" + quantity
          + "]";
    }
}
