package app.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import app.datasource.RecipeDatasource;
import app.recipe.Recipe;

public class RecipeServiceImpl implements RecipeService {

	private static final Logger logger = LoggerFactory.getLogger(RecipeServiceImpl.class);
	
	@Autowired
	private RecipeDatasource datasource;
	
	@Override
	public RecipesResponse getRecipes() {
		
		RecipesResponse response = new RecipesResponse();
		response.setCode("200");
		response.setDescription("ok");
		
		try{
			response.getRecipes().addAll(datasource.findAll());
		} catch (Exception e) {
			logger.error("Error al obtener las recetas de la base de datos.");
			response.setCode("500");
			response.setDescription("Ha ocurrido un error al consultar las recetas");
		}
		
		return response;
	}

	@Override
	public RecipesResponse addRecipe(Recipe recipe) {
		
		RecipesResponse response = new RecipesResponse();
		response.setCode("200");
		response.setDescription("ok");
		
		try{
			Long id = datasource.insertRecipe(recipe);
			response.getRecipes().add( datasource.findById(id) );
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error al insertar la receta en la base de datos.");
			response.setCode("500");
			response.setDescription("Ha ocurrido un error al añadir la receta");
		}
		
		return response;
	}
	
	@Override
	public RecipesResponse updateRecipe(Recipe recipe) {
		
		RecipesResponse response = new RecipesResponse();
		response.setCode("200");
		response.setDescription("ok");
		
		try{
			Long id = datasource.updateRecipe(recipe);
			response.getRecipes().add( datasource.findById(id) );
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error al actualizar la receta en la base de datos.");
			response.setCode("500");
			response.setDescription("Ha ocurrido un error al actualizar la receta");
		}
		
		return response;
	}

	@Override
	public RecipesResponse removeRecipe(Long id) {
		
		RecipesResponse response = new RecipesResponse();
		response.setCode("200");
		response.setDescription("ok");
		
		try{
			datasource.removeRecipe(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error al eliminar la receta en la base de datos.");
			response.setCode("500");
			response.setDescription("Ha ocurrido un error al eliminar la receta");
		}
		
		return response;
	}

}
