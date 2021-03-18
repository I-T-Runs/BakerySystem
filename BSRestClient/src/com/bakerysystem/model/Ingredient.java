package com.bakerysystem.model;


public class Ingredient {
	private int ingredientId; 
	private String ingredientName ;
	private int quantity ;
	
	public Ingredient(){}
	public Ingredient(int ingredientId, String ingredientName, int quantity) {
		super();
		setIngredientId(ingredientId);
                setIngredientName(ingredientName);
                setQuantity(quantity);
	}
        public void cosume(){
            
        }
        
	@Override
	public String toString() {
		return "Ingredient [ingredientId=" + ingredientId + ", ingredient=" + ingredientName + ", quantity=" + quantity
				+ "]";
	}
	public int getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}
	public String getIngredientName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	} 
}
