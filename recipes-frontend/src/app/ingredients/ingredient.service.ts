import { Injectable } from '@angular/core';
import {Subject} from "rxjs/Subject";
import {Ingredient} from "../shared/ingredient.model";

@Injectable()
export class IngredientService {

  ingredientsChanged = new Subject<Ingredient[]>();
  private ingredients: Ingredient[] = [];

  constructor() { }

  getIngredients() {
    return this.ingredients.slice();
  }

  setIngredients(ingredients : Ingredient[]) {
    this.ingredients = ingredients;
    this.ingredientsChanged.next(this.ingredients.slice())
  }

}
