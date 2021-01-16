import {IProduct} from './product';

export interface ICategory {
    categoryId?: number;
    name?: string;
    products?: IProduct[];
}

export class Category implements ICategory {
    constructor(
        public categoryId?: number,
        public name?: string,
        public products?: IProduct[]
    ) {
    }
}
