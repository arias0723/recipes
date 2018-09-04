package app.service;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import app.recipe.Recipe;


@Path("recipe")
@Component
@Consumes("application/json")
@Produces("application/json")
public interface RecipeService {
	

	/**
	 * Consulta todas las recetas almacenadas en el sistema y las devuelve.
	 * 
	 * @param
	 * @return Devuelve un objeto RecipeResponse que contiene una lista de las recetas en el sistema.
	 * @author Jose Arias
	 */
	@GET
	@Path("/all")
	public RecipesResponse getRecipes();

	/**
	 * Inserta una nueva receta en el sistema.
	 * 
	 * @param La nueva receta a añadir
	 * @return Devuelve un objeto RecipeResponse que contiene la receta añadida o el objeto
	 * RecipeResponse con la información del error en este caso.
	 * @author Jose Arias
	 */
	@POST
	@Path("/add")
	public RecipesResponse addRecipe(@Valid @RequestBody Recipe recipe);
	
	/**
	 * Actualiza una receta ya existente en el sistema.
	 * 
	 * @param La receta a actualizar
	 * @return Devuelve un objeto RecipeResponse que contiene la receta actualizada o el objeto
	 * RecipeResponse con la información del error en este caso.
	 * @author Jose Arias
	 */
	@PUT
	@Path("/update")
	public RecipesResponse updateRecipe(@Valid @RequestBody Recipe recipe);
	
	/**
	 * Elimina una receta ya existente en el sistema.
	 * 
	 * @param El id de la receta
	 * @return Devuelve un objeto RecipeResponse con la información de exito o error en el caso.
	 * @author Jose Arias
	 */
	@DELETE
	@Path("/remove/{id}")
	public RecipesResponse removeRecipe(@PathParam("id") Long id);
	

}
