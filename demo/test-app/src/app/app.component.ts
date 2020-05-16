import { Component, OnInit } from '@angular/core';
import { TestResponseService } from './test-response.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title:string="App"

  name:string = "Default";
  numVal:number = -4;

  constructor( private testResponse:TestResponseService)
  {}

  ngOnInit()
  {
    this.testResponse.getResponse().subscribe(
      response => this.handleResponse(response),
    );
  }

  handleResponse(response)
  {
    let obj = JSON.parse(JSON.stringify(response));

    this.name = obj.name;
    this.numVal = obj.value;

    console.log("works!")
  }
}
