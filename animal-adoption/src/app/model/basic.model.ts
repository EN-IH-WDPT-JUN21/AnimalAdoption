export class Basic {
    public get avaliable(): boolean {
        return this._avaliable;
    }
    public set avaliable(value: boolean) {
        this._avaliable = value;
    }
    public get age(): number {
        return this._age;
    }
    public set age(value: number) {
        this._age = value;
    }
    public get type(): string {
        return this._type;
    }
    public set type(value: string) {
        this._type = value;
    }
    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }

    constructor (private _name: string, private _type: string, private _age: number, private _avaliable: boolean){}
}