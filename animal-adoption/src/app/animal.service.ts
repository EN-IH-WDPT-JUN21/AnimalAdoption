import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Animal } from '../app/model/animal.model'

@Injectable({
  providedIn: 'root'
})
export class AnimalService {

  readonly baseURL: string = "https://localhost:8000/api/v1";

  constructor(private http: HttpClient) {}

  searchForAnimal(type?: string, age?: number) : Observable<any> {

    let httpParams = new HttpParams();
    if (age) httpParams = httpParams.append('age', age);      //payload
    if (type) httpParams = httpParams.append('type', type);  //payload

    const httpOptions = {
      params: httpParams
    };

    return this.http.get<any>(this.baseURL + "/animal/all");
  }
}
