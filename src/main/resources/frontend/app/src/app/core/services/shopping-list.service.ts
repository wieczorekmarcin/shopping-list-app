import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {AbstractRestService} from '../http/abstract-rest.service';
import {IShoppingList} from "../../shared/models/shopping-list";

@Injectable({providedIn: 'root'})
export class ShoppingListService extends AbstractRestService<IShoppingList> {

	constructor(http: HttpClient) {
		super(http,
			environment.apiEndpoint + environment.apiResource.shoppingList.resource
		);
	}
}
