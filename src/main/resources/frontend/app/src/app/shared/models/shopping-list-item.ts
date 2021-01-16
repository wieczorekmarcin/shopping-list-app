import {Product} from './product';

export interface IShoppingListItem {
    id?: number;
    purchased?: boolean;
    product?: Product;
}

export class ShoppingListItem implements IShoppingListItem {
    constructor(
        public id?: number,
        public purchased?: boolean,
        public product?: Product
    ) {
    }
}
