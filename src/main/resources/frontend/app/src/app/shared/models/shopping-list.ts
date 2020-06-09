import {Moment} from "moment";

export interface IShoppingList {
    id?: number;
    name?: string;
    description?: string;
    createdOn?: Moment;
    completed?: boolean;
    favourite?: boolean;
}

export class ShoppingList implements IShoppingList {
    constructor(
        public id?: number,
        public name?: string,
        public description?: string,
        public createdOn?: Moment,
        public completed?: boolean,
        public favourite?: boolean
    ) {
    }
}
