import java.util.ArrayList;

public class Product {
	private int productID ;
	private String productName ; 
	private Category category ; 
	private ArrayList<Ingredient> recipeArr ;
	private int  currentlyAvailable ;
	
	public Product(int productID, String productName, Category category, ArrayList<Ingredient> recipeArr,
			int currentlyAvailable) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.category = category;
		this.recipeArr = recipeArr;
		this.currentlyAvailable = currentlyAvailable;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", category=" + category
				+ ", currentlyAvailable=" + currentlyAvailable + "]";
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public ArrayList<Ingredient> getRecipeArr() {
		return recipeArr;
	}
	public void setRecipeArr(ArrayList<Ingredient> recipeArr) {
		this.recipeArr = recipeArr;
	}
	public int getCurrentlyAvailable() {
		return currentlyAvailable;
	}
	public void setCurrentlyAvailable(int currentlyAvailable) {
		this.currentlyAvailable = currentlyAvailable;
	} 
	
	
}
