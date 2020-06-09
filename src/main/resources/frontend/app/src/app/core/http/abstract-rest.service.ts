import {Observable} from 'rxjs';
import {createRequestOption, Search} from './request-util';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {map} from 'rxjs/operators';

export abstract class AbstractRestService<T> {
	protected constructor(protected http: HttpClient,
						  protected resourceUrl: string,
						  protected resourceSearchUrl: string) {
	}

	create(object: T): Observable<HttpResponse<T>> {
		return this.http
			.post<T>(this.resourceUrl, object, {observe: 'response'})
			.pipe(map((res: HttpResponse<T>) => this.convertDateFromServer(res)));
	}

	update(object: T): Observable<HttpResponse<T>> {
		return this.http
			.put<T>(this.resourceUrl, object, {observe: 'response'})
			.pipe(map((res: HttpResponse<T>) => this.convertDateFromServer(res)));
	}

	find(id: number): Observable<HttpResponse<T>> {
		return this.http
			.get<T>(`${this.resourceUrl}/${id}`, {observe: 'response'})
			.pipe(map((res: HttpResponse<T>) => this.convertDateFromServer(res)));
	}

	query(req?: any): Observable<HttpResponse<T[]>> {
		const options = createRequestOption(req);
		return this.http
			.get<T[]>(this.resourceUrl, {params: options, observe: 'response'})
			.pipe(map((res: HttpResponse<T[]>) => this.convertDateArrayFromServer(res)));
	}

	delete(id: number): Observable<HttpResponse<{}>> {
		return this.http.delete(`${this.resourceUrl}/${id}`, {observe: 'response'});
	}

	search(req: Search): Observable<HttpResponse<T[]>> {
		const options = createRequestOption(req);
		return this.http
			.get<T[]>(this.resourceSearchUrl, {params: options, observe: 'response'})
			.pipe(map((res: HttpResponse<T[]>) => this.convertDateArrayFromServer(res)));
	}

	protected convertDateFromClient(object: T): T {
		return object;
	}

	protected convertDateFromServer(res: HttpResponse<T>): HttpResponse<T> {
		return res;
	}

	protected convertDateArrayFromServer(res: HttpResponse<T[]>): HttpResponse<T[]> {
		return res;
	}
}
