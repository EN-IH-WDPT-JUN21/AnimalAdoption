import { AnimalService } from './../animal.service';
import { Component, OnInit } from '@angular/core';
import { Animal } from '../model/animal.model';
import { Basic } from '../model/basic.model';

@Component({
  selector: 'app-animal-adoption',
  templateUrl: './animal-adoption.component.html',
  styleUrls: ['./animal-adoption.component.css']
})
export class AnimalAdoptionComponent implements OnInit {

  name: string;
  type: string;
  age: number;
  avaliable: boolean;

  animalList: Array<Basic>
  animals;
  constructor(private service: AnimalService) { 
    this.animals = service.searchForAnimal();
    this.animalList = [new Basic("Reksio", "Dog", 8, true)];
    this.name ="";
    this.type = "";
    this.age = 0;
    this.avaliable = true;

    console.log(this.animals)
  }

  ngOnInit(): void {
    this.displayAnimal();
  }

  displayAnimal(): void {
    this.animals.subscribe(apiResponse => {
      const animal: Animal = apiResponse;
      const name: string = animal.results[0].name;
      const type: string = animal.results[0].type;
      const age: number = animal.results[0].age;
      const available: boolean = animal.results[0].avaliable;

      this.animalList.push(new Basic(name, type, age, available));
    }) 
  }

}
