import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Item } from '../items';


@Component({
  selector: 'app-searchproduct',
  templateUrl: './searchproduct.component.html',
  styleUrls: ['./searchproduct.component.css']
})
export class SearchproductComponent implements OnInit {
  title = 'product';
  itemName:string;
  items: Item[];
  constructor(private productService:ProductService) { }

  ngOnInit(): void {
    this.itemName = "";
  }

  search(){
    console.log("invoked search()");
   
    this.productService.getItems(this.itemName).subscribe(items=>this.items = items);    
  }

  onSubmit(){
  this.search();

}
}
