import { Component } from '@angular/core';
import { ProductService } from './product.service'
import { from } from 'rxjs';
import { Meta } from '@angular/platform-browser';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  //ite:Item = new Item();

  constructor(){

  
console.log("constructor invoked");
  }
  ngOnInit() {
   
  }

 
}
