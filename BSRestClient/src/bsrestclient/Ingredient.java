package bsrestclient;


public class Ingredient {
	private int ingredientId; 
	private String ingredient ;
	private int quantity ;
	
	public Ingredient(){}
	public Ingredient(int ingredientId, String ingredient, int quantity) {
		super();
		this.ingredientId = ingredientId;
		this.ingredient = ingredient;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Ingredient [ingredientId=" + ingredientId + ", ingredient=" + ingredient + ", quantity=" + quantity
				+ "]";
	}
	public int getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	} 

	
	
}
