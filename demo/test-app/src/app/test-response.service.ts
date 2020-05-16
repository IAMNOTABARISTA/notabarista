import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export class Test{
  constructor(
    public name:string,
    public value:number,
  ) {}
}

@Injectable({
  providedIn: 'root'
})
export class TestResponseService {

  constructor(
    private httpClient:HttpClient
  ) {
      console.log("HttpClient startup")
    }


  getResponse()
   {
    console.log("get response")
    return this.httpClient.get<Test>('http://localhost:8080/name')
  }
}
