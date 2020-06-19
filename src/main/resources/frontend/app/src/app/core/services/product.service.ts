import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {AbstractRestService} from '../http/abstract-rest.service';
import {IProduct} from "../../shared/models/product";

@Injectable({providedIn: 'root'})
export class ProductService extends AbstractRestService<IProduct> {

	constructor(http: HttpClient) {
		super(http,
			environment.apiEndpoint + environment.apiResource.product.resource
		);
	}
}
