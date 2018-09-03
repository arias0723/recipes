package app.datasource;

import java.util.List;

import app.recipe.Ingredient;

public interface IngredientDatasource {
	List<Ingredient> findAll();
}
