package app.datasource;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaUpdate;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import app.recipe.Ingredient;
import app.recipe.Recipe;

@Repository
@Transactional
public class RecipeDatasourceImpl  implements RecipeDatasource {
    
	@Autowired
	private SessionFactory sessionFactory;

	@Override
    public List<Recipe> findAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Recipe.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<Recipe>)criteria.list();
    }
	
	@Override
	public Recipe findById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Recipe r = session.get(Recipe.class, id);
		if(r == null) {
			throw new ObjectNotFoundException(id, Recipe.class.getName());
		}
		return r;
	}
	
	@Override
	public Long insertRecipe(Recipe recipe) {
		
		Session session = sessionFactory.getCurrentSession();		
		Long id = (Long)session.save(recipe);
		return id;
		
//		Recipe dbRecipe = new Recipe();
//		dbRecipe.setIngredients(new ArrayList<Ingredient>());
//		recipe.setId( (Long)session.save(dbRecipe) );
//		return this.updateRecipe(recipe);
	}
	
	@Override
	public Long updateRecipe(Recipe recipe) {
		
		Session session = sessionFactory.getCurrentSession();
		Recipe dbRecipe = session.get(Recipe.class, recipe.getId());
		
		dbRecipe.setName(recipe.getName());
		dbRecipe.setDescription(recipe.getDescription());
		dbRecipe.setImagePath(recipe.getImagePath());
		dbRecipe.getIngredients().clear();		
		List<Ingredient> newIngredients = recipe.getIngredients();
		if(newIngredients != null) {		
			dbRecipe.getIngredients().addAll(newIngredients);
		}
		
		return dbRecipe.getId();
	}
	
	@Override
	public void removeRecipe(Long id) {

		Session session = sessionFactory.getCurrentSession();
		Recipe dbRecipe = session.load(Recipe.class, id);
		session.delete(dbRecipe);
	}
    	
}
