//package app.service;
//
//import static org.junit.Assert.fail;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import static org.mockito.BDDMockito.*;
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.hamcrest.core.Is.is;
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import app.recipe.Recipe;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(RecipeService.class)
////@SpringBootTest
////@AutoConfigureMockMvc
//public class RecipeServiceTest {
//	
//	@Autowired
//	private MockMvc mvc;
//	@MockBean
//	private RecipeService recipeService;
//	
//	public RecipeServiceTest() {}
//	
//	@Test
//	public void getRecipes() throws Exception {
//		
//		Recipe recipe1 = new Recipe();
//		recipe1.setName("Hamburguesa");
//		recipe1.setDescription("Deliciosa hamburguesa con queso y más ...");
//		Recipe recipe2 = new Recipe();
//		recipe2.setName("Croquetas");
//		recipe2.setDescription("Con Ketchup ...");
//		
//		List<Recipe> allRecipes = new ArrayList<>();
//		allRecipes.add(recipe1);
//		allRecipes.add(recipe2);
//		
//		RecipesResponse resp = new RecipesResponse();
//		resp.setCode("ok");
//		resp.setDescription("");
//		resp.setRecipes(allRecipes);
//		
//	    given(recipeService.getRecipes()).willReturn(resp);
//	    
//	    mvc.perform(get("http://localhost:8080/api/recipe/all")
//	               .contentType(APPLICATION_JSON))
//	               .andExpect(status().isOk())
//	               .andExpect(jsonPath("recipes", hasSize(2)));
//	}
//
//}
