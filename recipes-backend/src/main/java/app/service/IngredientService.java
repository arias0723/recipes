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
		
	/**
	 * Consulta todos los ingredientes usados por recetas en el sistema. Los ingredientes repetidos 
	 * son agrupados por su nombre y se calcula la suma total de la cantidad de cada uno.
	 *  
	 * @param
	 * @return Devuelve un objeto IngredientResponse que contiene una lista de las ingredientes.
	 * @author Jose Arias
	 */
	@GET
	@Path("/all")
	public IngredientResponse getIngredients();

}
