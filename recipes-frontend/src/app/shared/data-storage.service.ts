import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { HttpHeaders } from '@angular/common/http';
import 'rxjs/Rx';

import { RecipeService } from '../recipes/recipe.service';
import { Recipe } from '../recipes/recipe.model';
import {RecipesResponse} from '../recipes/recipe.response.model';
import {IngredientService} from "../ingredients/ingredient.service";
import {Ingredient} from "./ingredient.model";
import {IngredientsResponse} from "../ingredients/ingredient.response.model";

// const httpOptions = {
//   headers: new HttpHeaders({
//     'Content-Type':  'application/json'
//   })
// };

@Injectable()
export class DataStorageService {

  constructor(private http: Http, private recipeService: RecipeService,
              private ingredientService: IngredientService) {}

  getRecipes() {
    this.http.get('http://localhost:8080/api/recipe/all')
      .map(
        (response: Response) => {
          const recipesResponse: RecipesResponse = response.json();
          const recipes = recipesResponse.recipes;
          for (const recipe of recipesResponse.recipes) {
            if (!recipe['ingredients']) {
              recipe['ingredients'] = [];
            }
          }
          return recipes;
        }
      )
      .subscribe(
        (recipes: Recipe[]) => {
          this.recipeService.setRecipes(recipes);
          console.log(recipes);
        }
      );
  }

  addRecipe(recipe: Recipe) {
    this.http.post('http://localhost:8080/api/recipe/add', recipe)
      .map(
        (response: Response) => {
          const recipesResponse: RecipesResponse = response.json();
          const recipes = recipesResponse.recipes;
          for (const recipe of recipesResponse.recipes) {
            if (!recipe['ingredients']) {
              recipe['ingredients'] = [];
            }
          }
          return recipes[0];
        }
      )
      .subscribe(
        (recipe: Recipe) => {
          console.log(recipe);
          //this.recipeService.addRecipe(recipe);
        }
      );
  }

  updateRecipe(recipe: Recipe) {
    this.http.put('http://localhost:8080/api/recipe/update', recipe)
      .map(
        (response: Response) => {
          const recipesResponse: RecipesResponse = response.json();
          const recipes = recipesResponse.recipes;
          for (const recipe of recipesResponse.recipes) {
            if (!recipe['ingredients']) {
              recipe['ingredients'] = [];
            }
          }
          return recipes[0];
        }
      )
      .subscribe(
        (recipe: Recipe) => {
          console.log(recipe);
          //this.recipeService.addRecipe(recipe);
        }
      );
  }

  deleteRecipe(recipeId: number) {
    this.http.delete('http://localhost:8080/api/recipe/remove/' + recipeId)
      .map(
        (response: Response) => {
          const recipesResponse: RecipesResponse = response.json();
          const recipes = recipesResponse.recipes;
          for (const recipe of recipesResponse.recipes) {
            if (!recipe['ingredients']) {
              recipe['ingredients'] = [];
            }
          }
          return recipes[0];
        }
      )
      .subscribe(
        (recipe: Recipe) => {
          console.log('Receta eliminada');
          //this.recipeService.addRecipe(recipe);
        }
      );
  }

  getIngredients() {
    this.http.get('http://localhost:8080/api/ingredient/all')
      .map(
        (response: Response) => {
          const ingredientsResponse: IngredientsResponse = response.json();
          const ingredients = ingredientsResponse.ingredients;
          // const ingredients: Ingredient[] = [<Ingredient>{name: 'i1', amount: 2}, <Ingredient>{name: 'i2', amount: 8}];
          let mappedIngredients: Ingredient[] = ingredients.map(item => new Ingredient(item[0], item[1]));

          return mappedIngredients;
        }
      )
      .subscribe(
        (ingredients: Ingredient[]) => {
          console.log(ingredients);
          this.ingredientService.setIngredients(ingredients);
        }
      );
  }

}
