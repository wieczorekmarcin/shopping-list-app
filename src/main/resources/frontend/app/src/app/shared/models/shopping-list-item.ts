import {Product} from "./product";
import {ShoppingList} from "./shopping-list";

export interface IShoppingListItem {
    id?: number;
    purchased?: boolean;
    product?: Product;
    shoppingList?: ShoppingList;
}

export class ShoppingListItem implements IShoppingListItem {
    constructor(
        public id?: number,
        public purchased?: boolean,
        public product?: Product,
        public shoppingList?: ShoppingList
    ) {
    }
}
