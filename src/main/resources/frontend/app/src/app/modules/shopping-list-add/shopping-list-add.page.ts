import {Component, OnInit} from '@angular/core';
import {ModalController} from "@ionic/angular";

@Component({
	selector: 'app-shopping-list-add',
	templateUrl: './shopping-list-add.page.html',
	styleUrls: ['./shopping-list-add.page.scss'],
})
export class ShoppingListAddPage implements OnInit {

	constructor(private modalController: ModalController) {
	}

	ngOnInit() {
	}

	async dismiss() {
		await this.modalController.dismiss({
			'dismissed': true
		});
	}
}
