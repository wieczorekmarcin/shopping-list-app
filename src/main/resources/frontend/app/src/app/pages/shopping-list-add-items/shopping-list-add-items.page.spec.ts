import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {IonicModule} from '@ionic/angular';

import {ShoppingListAddItemsPage} from './shopping-list-add-items.page';

describe('ShoppingListAddItemsPage', () => {
    let component: ShoppingListAddItemsPage;
    let fixture: ComponentFixture<ShoppingListAddItemsPage>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [ShoppingListAddItemsPage],
            imports: [IonicModule.forRoot()]
        }).compileComponents();

        fixture = TestBed.createComponent(ShoppingListAddItemsPage);
        component = fixture.componentInstance;
        fixture.detectChanges();
    }));

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
