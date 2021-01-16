import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

import {IonicModule} from '@ionic/angular';

import {ProductsPageRoutingModule} from './products-routing.module';

import {ProductsPage} from './products.page';
import {MatExpansionModule} from "@angular/material/expansion";

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        IonicModule,
        ProductsPageRoutingModule,
        MatExpansionModule
    ],
    declarations: [ProductsPage]
})
export class ProductsPageModule {
}
