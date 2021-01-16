import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

import {IonicModule} from '@ionic/angular';

import {RecipiesPageRoutingModule} from './recipies-routing.module';

import {RecipesPage} from './recipes-page.component';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        IonicModule,
        RecipiesPageRoutingModule
    ],
    declarations: [RecipesPage]
})
export class RecipiesPageModule {
}
