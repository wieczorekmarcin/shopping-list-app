import {Component, OnInit} from '@angular/core';
import {ModalController} from "@ionic/angular";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ShoppingListService} from "../../core/services/shopping-list.service";
import * as moment from 'moment';
import {Router} from "@angular/router";

@Component({
	selector: 'app-shopping-list-add',
	templateUrl: './shopping-list-add.page.html',
	styleUrls: ['./shopping-list-add.page.scss'],
})
export class ShoppingListAddPage implements OnInit {

	shoppingListForm: FormGroup;

	submitted = false;

	constructor(private modalController: ModalController,
				private formBuilder: FormBuilder,
				private shoppingListService: ShoppingListService) {
	}

	ngOnInit() {
		this.initForm();
	}

	initForm() {
		this.shoppingListForm = this.formBuilder.group({
			name: ['', [Validators.required]],
			description: ['', [Validators.required]],
		});
	}

	get form() {
		return this.shoppingListForm.controls;
	}

	getValue(key: string) {
		return this.shoppingListForm.get(key).value;
	}

	async onSubmit() {
		this.submitted = true;

		if (this.shoppingListForm.invalid) {
			return;
		}

		this.shoppingListService.create({
			name: this.getValue('name'),
			description: this.getValue('description'),
			createdOn: moment()
		}).subscribe();

		await this.dismiss();
	}

	async dismiss() {
		await this.modalController.dismiss({
			'dismissed': true
		});
	}
}
