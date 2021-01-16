export interface IProduct {
    id?: number;
    name?: string;
    category?: string;
    unit?: string;
    added?: boolean;
}

export class Product implements IProduct {
    constructor(
        public id?: number,
        public name?: string,
        public category?: string,
        public unit?: string,
        public added?: boolean
    ) {
    }
}
