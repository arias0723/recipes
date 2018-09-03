package app.service;

import java.util.ArrayList;
import java.util.List;

import app.recipe.Ingredient;

public class IngredientResponse extends AbstractResponse {

	private List<Ingredient> ingredients;

	public List<Ingredient> getIngredients() {
		if(ingredients==null)
			ingredients= new ArrayList<Ingredient>();
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
}
