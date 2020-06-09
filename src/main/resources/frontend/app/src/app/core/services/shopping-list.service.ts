import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {AbstractRestService} from '../http/abstract-rest.service';
import {IProduct} from "../../shared/models/product";
import {IUnit} from "../../shared/models/unit";
import {ICategory} from "../../shared/models/category";
import {IShoppingList} from "../../shared/models/shopping-list";

@Injectable({providedIn: 'root'})
export class ShoppingListService extends AbstractRestService<IShoppingList> {

    constructor(http: HttpClient) {
        super(http,
            environment.apiEndpoint + environment.apiResource.shoppingList.resource
        );
    }
}
