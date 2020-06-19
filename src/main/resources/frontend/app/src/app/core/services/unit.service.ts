import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {AbstractRestService} from '../http/abstract-rest.service';
import {IUnit} from "../../shared/models/unit";

@Injectable({providedIn: 'root'})
export class UnitService extends AbstractRestService<IUnit> {

	constructor(http: HttpClient) {
		super(http,
			environment.apiEndpoint + environment.apiResource.unit.resource
		);
	}
}
