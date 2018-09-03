package app.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

@Path("ingredient")
@Component
@Consumes("application/json")
@Produces("application/json")
public interface IngredientService {
		
	@GET
	@Path("/all")
	public IngredientResponse getIngredients();

}
