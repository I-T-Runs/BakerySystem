package Model;

import Model.Ingredient;
import java.util.ArrayList;

public class Product {
	private int productID ;
	private String productName ; 
        private String photo;
	private int categoryID; 
	private ArrayList<Ingredient> recipeArr ;
	private int  currentlyAvailable ;
        private double price;
        private double actualPrice;
        private int discount;       
        private String productDescription;
        private String productWarnings;
        

        public Product() {
    
        }
   
	public Product(int productID, String productName, String photo, int categoryID, Double price, int discount, ArrayList<Ingredient> recipeArr, String productDescription, String productWarnings) {
		super();
		setProductID(productID);
                setProductName(productName);
                setPhoto(photo);
                setCategoryID(categoryID);
                setPrice(price);
                setDiscount(discount);
                setRecipeArr(recipeArr);
                setProductDescription(productDescription);
                setProductWarnings(productWarnings);
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", category=" + categoryID
				+ ", currentlyAvailable=" + currentlyAvailable + "]";
	}
    public int getProductID() {
        return productID;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
        setActualPrice((double)((100-discount)/100)*this.price);
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

        public int getCategoryID() {
            return categoryID;
        }

        public void setCategoryID(int categoryID) {
            this.categoryID = categoryID;
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

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public double getActualPrice() {
            return actualPrice;
        }

        public void setActualPrice(double actualPrice) {
            this.actualPrice = actualPrice;
        }

        public String getProductDescription() {
            return productDescription;
        }

        public void setProductDescription(String productDescription) {
            this.productDescription = productDescription;
        }

    public String getProductWarnings() {
        return this.productWarnings;
    }

    public void setProductWarnings(String productWarnings) {
        this.productWarnings = productWarnings;
    }
        
}
