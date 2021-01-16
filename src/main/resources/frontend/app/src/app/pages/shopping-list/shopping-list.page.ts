import {Component, OnInit} from '@angular/core';
import {ModalController, ToastController} from '@ionic/angular';
import {IShoppingList, ShoppingList} from '../../shared/models/shopping-list';
import {ShoppingListService} from '../../core/services/shopping-list.service';
import {ShoppingListAddPage} from '../shopping-list-add/shopping-list-add.page';
import {Router} from '@angular/router';

@Component({
    selector: 'app-shopping-list',
    templateUrl: './shopping-list.page.html',
    styleUrls: ['./shopping-list.page.scss'],
})
export class ShoppingListPage implements OnInit {

    shoppingLists: IShoppingList[];

    constructor(private modalController: ModalController,
                private toastController: ToastController,
                private router: Router,
                private shoppingListService: ShoppingListService) {
    }

    async ngOnInit() {
        await this.getAllShoppingLists();
        this.markShoppingListsAsCompleted();
    }

    async ionViewWillEnter() {
        await this.getAllShoppingLists();
        this.markShoppingListsAsCompleted();
    }

    async getAllShoppingLists() {
        const shoppingListsResponse = await this.shoppingListService.query().toPromise();

        this.shoppingLists = shoppingListsResponse.body
            .filter(sl => sl.deleted === false);
    }

    async addShoppingList() {
        const modal = await this.modalController.create({
            component: ShoppingListAddPage
        });

        modal.onDidDismiss()
            .then(async () => await this.getAllShoppingLists());

        return await modal.present();
    }

    async deleteShoppingList(shoppingList: ShoppingList) {
        shoppingList.deleted = true;
        this.shoppingListService.update(shoppingList).subscribe();

        await this.presentToast('Shopping List has been removed!');

        await this.getAllShoppingLists();
    }

    getPurchasedShoppingListItems(shoppingList: ShoppingList) {
        return shoppingList.items
            .filter(item => item.purchased === true)
            .length;
    }

    getAllShoppingListItems(shoppingList: ShoppingList) {
        return shoppingList.items.length;
    }

    getCurrentShoppingListStatus(shoppingList: ShoppingList) {
        const allShoppingListItems = this.getAllShoppingListItems(shoppingList);
        const purchasedShoppingListItems = this.getPurchasedShoppingListItems(shoppingList);
        return allShoppingListItems === 0
            ? 0
            : (purchasedShoppingListItems / allShoppingListItems);
    }

    async editShoppingListItems(shoppingList: IShoppingList) {
        await this.router.navigate(['shopping-list-add-items'], {state: {shoppingList}});
    }


    async addShoppingListToFavourites(shoppingList: IShoppingList) {
        shoppingList.favourite
            ? shoppingList.favourite = false
            : shoppingList.favourite = true;

        this.shoppingListService.update(shoppingList).subscribe();

        await this.presentToast(
            shoppingList.favourite
                ? 'Shopping List has been added to favourites!'
                : 'Shopping List has been removed from favourites!');
    }

    markShoppingListsAsCompleted() {
        this.shoppingLists.forEach(shoppingList => {
            const allShoppingListItems = this.getAllShoppingListItems(shoppingList);
            const purchased = this.getPurchasedShoppingListItems(shoppingList);

            (allShoppingListItems && purchased !== 0) && (allShoppingListItems / purchased === 1)
                ? shoppingList.completed = true
                : shoppingList.completed = false;

            this.shoppingListService.update(shoppingList).subscribe();
        });
    }

    async presentToast(msg: string) {
        const toast = await this.toastController.create({
            message: msg,
            duration: 2000
        });
        await toast.present();
    }
}
