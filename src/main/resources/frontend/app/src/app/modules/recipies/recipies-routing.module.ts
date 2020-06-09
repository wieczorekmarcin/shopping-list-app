import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {RecipiesPage} from './recipies.page';

const routes: Routes = [
	{
		path: '',
		component: RecipiesPage
	}
];

@NgModule({
	imports: [RouterModule.forChild(routes)],
	exports: [RouterModule],
})
export class RecipiesPageRoutingModule {
}
