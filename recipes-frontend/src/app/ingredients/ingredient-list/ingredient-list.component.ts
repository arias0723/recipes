import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {DataStorageService} from "../../shared/data-storage.service";
import {Subscription} from "rxjs/Subscription";
import {IngredientService} from "../ingredient.service";
import {Ingredient} from "../../shared/ingredient.model";

@Component({
  selector: 'app-ingredient-list',
  templateUrl: './ingredient-list.component.html',
  styleUrls: ['./ingredient-list.component.css']
})
export class IngredientListComponent implements OnInit {

  ingredients: Ingredient[];
  subscription: Subscription;

  constructor(private ingredientService: IngredientService,
              private router: Router,
              private route: ActivatedRoute,
              private dataSourceService: DataStorageService) {
  }

  ngOnInit() {
    this.subscription = this.ingredientService.ingredientsChanged
      .subscribe(
        (ingredients: Ingredient[]) => {
          this.ingredients = ingredients;
        }
      );
    this.ingredients = this.ingredientService.getIngredients();
    this.dataSourceService.getIngredients();
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  onNewRecipe() {
    this.router.navigateByUrl('recipes/add');
  }

}
