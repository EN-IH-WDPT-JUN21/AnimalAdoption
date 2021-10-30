export class Animal {

    constructor (private _results: AnimalInfo[]){}

    public get results(): AnimalInfo[] {
        return this._results;
    }
    public set results(value: AnimalInfo[]) {
        this._results = value;
    }

}


interface AnimalInfo {
/*     id: number, */
    name: string,
    type: string,
    age: number,
    avaliable: boolean
}