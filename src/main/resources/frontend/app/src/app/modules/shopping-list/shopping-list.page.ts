import {Component, OnInit} from '@angular/core';
import {ModalController} from "@ionic/angular";
import {ShoppingListAddPage} from "../shopping-list-add/shopping-list-add.page";
import {IShoppingList} from "../../shared/models/shopping-list";
import {ShoppingListService} from "../../core/services/shopping-list.service";
import {FormBuilder} from "@angular/forms";

@Component({
	selector: 'app-shopping-list',
	templateUrl: './shopping-list.page.html',
	styleUrls: ['./shopping-list.page.scss'],
})
export class ShoppingListPage implements OnInit {

	shoppingLists: IShoppingList[];

	constructor(private modalController: ModalController,
				private shoppingList: ShoppingListService) {
	}

	async ngOnInit() {
		await this.getAllShoppingLists();
	}

	async getAllShoppingLists() {
		const shoppingListsResponse = await this.shoppingList.query().toPromise();
		this.shoppingLists = shoppingListsResponse.body;
	}

	async addShoppingList() {
		const modal = await this.modalController.create({
			component: ShoppingListAddPage

		});

		modal.onDidDismiss().then(async () => await this.getAllShoppingLists());

		return await modal.present();
	}
}
