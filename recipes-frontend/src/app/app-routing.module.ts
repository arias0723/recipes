import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RecipesComponent } from './recipes/recipes.component';
import { RecipeStartComponent } from './recipes/recipe-start/recipe-start.component';
import { RecipeDetailComponent } from './recipes/recipe-detail/recipe-detail.component';
import {RecipeAddComponent} from "./recipes/recipe-add/recipe-add.component";
import {RecipeEditComponent} from "./recipes/recipe-edit/recipe-edit.component";
import {IngredientsComponent} from "./ingredients/ingredients.component";


const appRoutes: Routes = [
  { path: '', redirectTo: '/recipes', pathMatch: 'full' },
  { path: 'recipes', component: RecipesComponent, children: [
      { path: '', component: RecipeStartComponent },
      { path: 'add', component: RecipeEditComponent },
      { path: ':id', component: RecipeDetailComponent },
      { path: ":id/edit", component: RecipeEditComponent }
  ] },
  { path: 'ingredients', component: IngredientsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
