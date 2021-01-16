import {Moment} from 'moment';
import {IShoppingListItem} from './shopping-list-item';

export interface IShoppingList {
    shoppingListId?: number;
    name?: string;
    description?: string;
    createdOn?: Moment;
    completed?: boolean;
    favourite?: boolean;
    deleted?: boolean;
    items?: IShoppingListItem[];
}

export class ShoppingList implements IShoppingList {
    constructor(
        public shoppingListId?: number,
        public name?: string,
        public description?: string,
        public createdOn?: Moment,
        public completed?: boolean,
        public favourite?: boolean,
        public deleted?: boolean,
        public items?: IShoppingListItem[]
    ) {
    }
}
