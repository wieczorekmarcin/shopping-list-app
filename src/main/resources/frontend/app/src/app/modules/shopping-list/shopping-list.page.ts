import {Component, OnInit} from '@angular/core';
import {ModalController} from "@ionic/angular";
import {ShoppingListAddPage} from "../shopping-list-add/shopping-list-add.page";

@Component({
	selector: 'app-shopping-list',
	templateUrl: './shopping-list.page.html',
	styleUrls: ['./shopping-list.page.scss'],
})
export class ShoppingListPage implements OnInit {

	constructor(private modalController: ModalController) {
	}

	ngOnInit() {
	}

	async addNewShoppingList() {
		const modal = await this.modalController.create({
			component: ShoppingListAddPage,
			cssClass: 'my-custom-class'
		});
		return await modal.present();
	}
}
