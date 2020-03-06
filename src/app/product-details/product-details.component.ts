import { Component, OnInit, Input } from '@angular/core';
import { Item, Cart } from '../items';
import { from } from 'rxjs';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
 
  @Input() 
  item :Item;
  product:any;
  cart:Cart = new Cart();

  constructor(private productService : ProductService ) { }
  
  ngOnInit(): void {
  }

  onSave(itemId : number){
    
 this.cart.itemId=this.item.itemId;
 this.cart.description=this.item.description;
 this.cart.quantity=this.item.stockNumber;
    this.productService.addToCart(this.cart).subscribe(product=>{this.product=product;},
      error => console.log('erorr'+error));
  }
}
