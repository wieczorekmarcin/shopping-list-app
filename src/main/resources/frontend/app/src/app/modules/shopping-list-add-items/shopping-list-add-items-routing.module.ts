import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {ShoppingListAddItemsPage} from './shopping-list-add-items.page';

const routes: Routes = [
	{
		path: '',
		component: ShoppingListAddItemsPage
	}
];

@NgModule({
	imports: [RouterModule.forChild(routes)],
	exports: [RouterModule],
})
export class ShoppingListAddItemsPageRoutingModule {
}
