import {Component, OnInit} from '@angular/core';
import {LoadingController, ModalController, ToastController} from "@ionic/angular";
import {ProductService} from "../../core/services/product.service";
import {IProduct} from "../../shared/models/product";
import {ICategory} from "../../shared/models/category";
import {CategoryService} from "../../core/services/category.service";
import {ShoppingListItemService} from "../../core/services/shopping-list-item.service";
import {IShoppingList} from "../../shared/models/shopping-list";
import {ShoppingListService} from "../../core/services/shopping-list.service";

@Component({
	selector: 'app-products',
	templateUrl: './products.page.html',
	styleUrls: ['./products.page.scss'],
})
export class ProductsPage implements OnInit {

	shoppingList: IShoppingList;

	categories: ICategory[]

	constructor(private modalController: ModalController,
				private productService: ProductService,
				private shoppingListItemService: ShoppingListItemService,
				private shoppingListService: ShoppingListService,
				private categoryService: CategoryService,
				private toastController: ToastController,
				private loadingController: LoadingController) {
	}

	async ngOnInit() {
		await this.getCategories();
	}

	async getCategories() {
		const loading = await this.loadingController.create({
			message: 'Proszę czekać...',
		});
		loading.present().then(async () => {
			let categoriesResponse = await this.categoryService.query().toPromise();
			this.categories = categoriesResponse.body;
		}).then(() => {
			loading.dismiss();
		});
	}

	async dismiss() {
		await this.modalController.dismiss({
			'dismissed': true
		});
	}

	async createShoppingListItem(product: IProduct) {
		product.added = true;
		const shoppingListItemHttpResponse = await this.shoppingListItemService.create({
			product: {
				id: product.id
			},
			purchased: false,
		}).toPromise()

		const shoppingListItem = shoppingListItemHttpResponse.body;
		this.shoppingList.items.push(shoppingListItem);
		this.shoppingListService.update(this.shoppingList).subscribe();

		await this.presentToast();
	}

	async presentToast() {
		const toast = await this.toastController.create({
			message: 'Produkt dodany do listy!',
			color: 'success',
			duration: 2000
		});
		toast.present();
	}

	async presentLoading() {
		const loading = await this.loadingController.create({
			message: 'Proszę czekać...',
			duration: 2000,
			translucent: true,
		});
		await loading.present();

		return loading;
	}
}
