import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Cart } from '../items';

@Component({
  selector: 'app-displaycart',
  templateUrl: './displaycart.component.html',
  styleUrls: ['./displaycart.component.css']
})
export class DisplaycartComponent implements OnInit {


  displayCart:Cart[];

  constructor(private displaycart:ProductService) { }

  ngOnInit(): void {

  
    this.displaycart.displayCartItems().subscribe( displayCart => this.displayCart=displayCart);
    console.log(this.displayCart);
    
  }


}

