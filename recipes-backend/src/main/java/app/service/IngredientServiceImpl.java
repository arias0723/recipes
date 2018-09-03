package app.service;

import javax.ws.rs.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import app.datasource.IngredientDatasource;

public class IngredientServiceImpl implements IngredientService {

	private static final Logger logger = LoggerFactory.getLogger(IngredientServiceImpl.class);
	
	@Autowired
	private IngredientDatasource datasource;
	
	@Override
	public IngredientResponse getIngredients() {
		
		IngredientResponse response = new IngredientResponse();
		response.setCode("200");
		response.setDescription("ok");
		
		try{
			response.getIngredients().addAll(datasource.findAll());
			
		} catch (Exception e) {
			logger.error("Error al obtener las recetas de la base de datos.");
			response.setCode("500");
			response.setDescription("Ha ocurrido un error al consultar las recetas");
		}
		
		return response;
	}
	
}
