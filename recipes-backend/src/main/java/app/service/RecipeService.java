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
	
	@GET
	@Path("/all")
	public RecipesResponse getRecipes();

	@POST
	@Path("/add")
	public RecipesResponse addRecipe(@Valid @RequestBody Recipe recipe);
	
	@PUT
	@Path("/update")
	public RecipesResponse updateRecipe(@Valid @RequestBody Recipe recipe);
	
	@DELETE
	@Path("/remove/{id}")
	public RecipesResponse removeRecipe(@PathParam("id") Long id);
	

}
