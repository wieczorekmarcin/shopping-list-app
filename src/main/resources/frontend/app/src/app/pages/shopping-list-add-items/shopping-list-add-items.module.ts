import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

import {IonicModule} from '@ionic/angular';

import {ShoppingListAddItemsPageRoutingModule} from './shopping-list-add-items-routing.module';

import {ShoppingListAddItemsPage} from './shopping-list-add-items.page';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        IonicModule,
        ShoppingListAddItemsPageRoutingModule
    ],
    declarations: [ShoppingListAddItemsPage]
})
export class ShoppingListAddItemsPageModule {
}
