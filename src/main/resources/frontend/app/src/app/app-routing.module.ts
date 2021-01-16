import {NgModule} from '@angular/core';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';

const routes: Routes = [
	{
		path: '',
		redirectTo: 'shopping-list',
		pathMatch: 'full'
	},
	{
		path: 'recipes',
		loadChildren: () => import('./pages/recipes/recipies.module').then(m => m.RecipiesPageModule)
	},
	{
		path: 'promotions',
		loadChildren: () => import('./pages/promotions/promotions.module').then(m => m.PromotionsPageModule)
	},
	{
		path: 'trash',
		loadChildren: () => import('./pages/trash/trash.module').then(m => m.TrashPageModule)
	},
	{
		path: 'settings',
		loadChildren: () => import('./pages/settings/settings.module').then(m => m.SettingsPageModule)
	},
	{
		path: 'shopping-list-add',
		loadChildren: () => import('./pages/shopping-list-add/shopping-list-add.module').then(m => m.ShoppingListAddPageModule)
	},
	{
		path: 'shopping-list',
		loadChildren: () => import('./pages/shopping-list/shopping-list.module').then(m => m.ShoppingListPageModule)
	},
	{
		path: 'shopping-list-add-items',
		loadChildren: () => import('./pages/shopping-list-add-items/shopping-list-add-items.module').then(m => m.ShoppingListAddItemsPageModule)
	},
	{
		path: 'products',
		loadChildren: () => import('./pages/products/products.module').then(m => m.ProductsPageModule)
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
