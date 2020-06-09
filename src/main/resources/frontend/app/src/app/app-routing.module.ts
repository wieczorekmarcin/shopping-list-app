import {NgModule} from '@angular/core';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';

const routes: Routes = [
	{
		path: '',
		redirectTo: 'shopping-list',
		pathMatch: 'full'
	},
	{
		path: 'recipies',
		loadChildren: () => import('./modules/recipies/recipies.module').then(m => m.RecipiesPageModule)
	},
	{
		path: 'promotions',
		loadChildren: () => import('./modules/promotions/promotions.module').then(m => m.PromotionsPageModule)
	},
	{
		path: 'trash',
		loadChildren: () => import('./modules/trash/trash.module').then(m => m.TrashPageModule)
	},
	{
		path: 'settings',
		loadChildren: () => import('./modules/settings/settings.module').then(m => m.SettingsPageModule)
	},
  {
    path: 'shopping-list-add',
    loadChildren: () => import('./modules/shopping-list-add/shopping-list-add.module').then( m => m.ShoppingListAddPageModule)
  },
  {
    path: 'shopping-list',
    loadChildren: () => import('./modules/shopping-list/shopping-list.module').then( m => m.ShoppingListPageModule)
  },
];

@NgModule({
	imports: [
		RouterModule.forRoot(routes, {preloadingStrategy: PreloadAllModules})
	],
	exports: [RouterModule]
})
export class AppRoutingModule {
}
