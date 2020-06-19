export interface IUnit {
	id?: number;
	symbol?: string;
}

export class Unit implements IUnit {
	constructor(
		public id?: number,
		public symbol?: string
	) {
	}
}
