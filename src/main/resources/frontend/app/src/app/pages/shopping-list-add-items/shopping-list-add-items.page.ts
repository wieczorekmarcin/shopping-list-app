import {Component, OnInit} from '@angular/core';
import {ModalController} from '@ionic/angular';
import {IShoppingList} from '../../shared/models/shopping-list';
import {Router} from '@angular/router';
import {ShoppingListService} from '../../core/services/shopping-list.service';
import {ProductsPage} from '../products/products.page';
import {ShoppingListItemService} from '../../core/services/shopping-list-item.service';
import {IShoppingListItem} from '../../shared/models/shopping-list-item';

@Component({
    selector: 'app-shopping-list-add-items',
    templateUrl: './shopping-list-add-items.page.html',
    styleUrls: ['./shopping-list-add-items.page.scss'],
})
export class ShoppingListAddItemsPage implements OnInit {

    shoppingList: IShoppingList;

    shoppingListItems: IShoppingListItem[];

    constructor(private modalController: ModalController,
                private router: Router,
                private shoppingListItemService: ShoppingListItemService,
                private shoppingListService: ShoppingListService) {
    }

    async ngOnInit() {
        this.shoppingList = this.router.getCurrentNavigation().extras.state.shoppingList;
        await this.getAllShoppingListItems();
    }

    async ionViewWillEnter() {
        await this.getAllShoppingListItems();
    }

    async getAllShoppingListItems() {
        const shoppingListResponse = await this.shoppingListService.find(this.shoppingList.shoppingListId).toPromise();
        this.shoppingList = shoppingListResponse.body;
        this.shoppingListItems = this.shoppingList.items;
    }

    async addProduct(shoppingList: IShoppingList) {
        const modal = await this.modalController.create({
            component: ProductsPage,
            componentProps: {
                shoppingList
            }
        });

        modal.onDidDismiss()
            .then(async () => await this.getAllShoppingListItems());

        return await modal.present();
    }

    markAsPurchased(shoppingListItems: IShoppingListItem) {
        shoppingListItems.purchased
            ? shoppingListItems.purchased = true
            : shoppingListItems.purchased = false;
        this.shoppingListItemService.update(shoppingListItems).subscribe();
    }
}
