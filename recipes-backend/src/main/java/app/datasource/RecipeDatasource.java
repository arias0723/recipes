package app.datasource;

import java.util.List;
import app.recipe.Recipe;


public interface RecipeDatasource {

	List<Recipe> findAll();
	Recipe findById(Long id);
	Long insertRecipe(Recipe recipe);
	Long updateRecipe(Recipe recipe);
	void removeRecipe(Long id);
//	Long saveOrUpdateRecipe(Recipe recipe);
}
