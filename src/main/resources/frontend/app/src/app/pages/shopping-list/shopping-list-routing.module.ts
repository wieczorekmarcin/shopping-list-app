import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {ShoppingListPage} from './shopping-list.page';
import {MomentModule} from "ngx-moment";

const routes: Routes = [
    {
        path: '',
        component: ShoppingListPage
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes), MomentModule],
    exports: [RouterModule],
})
export class ShoppingListPageRoutingModule {
}
