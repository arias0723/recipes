package app.datasource;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.recipe.Ingredient;
import app.recipe.Recipe;

@Repository
@Transactional
public class IngredientDatasourceImpl implements IngredientDatasource {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Ingredient> findAll() {
		// SELECT name, SUM(amount) FROM prueba.ingredient GROUP BY name;
		Session session = sessionFactory.getCurrentSession();
		List<Ingredient> ingredients = (List<Ingredient>)session.createCriteria(Ingredient.class)
											.setProjection(Projections.projectionList()
													.add(Projections.groupProperty("name"))
													.add(Projections.sum("amount"))													
											).list();
		
		return ingredients;
	}

}
