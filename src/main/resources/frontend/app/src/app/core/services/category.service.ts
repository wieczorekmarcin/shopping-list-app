import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {AbstractRestService} from '../http/abstract-rest.service';
import {ICategory} from "../../shared/models/category";

@Injectable({providedIn: 'root'})
export class CategoryService extends AbstractRestService<ICategory> {

    constructor(http: HttpClient) {
        super(http,
            environment.apiEndpoint + environment.apiResource.category.resource
        );
    }
}
