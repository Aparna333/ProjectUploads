import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Item } from '../items';

@Component({
  selector: 'app-seller',
  templateUrl: './seller.component.html',
  styleUrls: ['./seller.component.css']
})
export class SellerComponent implements OnInit {

itemId:number;
price:number;
category:number;
subCategory:number;
itemName:String;
description:String;
stockNumber:number;
remarks:String;
manufacturer: String;
deleteItem:number;
items:Item=new Item();

  constructor(private sellerService: ProductService) { }

  ngOnInit(): void {
  }
  additems() 
  {
this.items.itemName=this.itemName;
this.items.price=this.price;
this.items.category=this.category;
this.items.subCategory=this.subCategory;
this.items.description=this.description;
this.items.stockNumber=this.stockNumber;
this.items.manufacturer=this.manufacturer;
this.items.remarks=this.remarks;
this.sellerService.additems(this.items).subscribe(ItemEntity=>this.items=ItemEntity);
 
  } 
  deleteitem() 
  { 
    console.log("in delete");
    this.sellerService.deleteitem(this.deleteItem).subscribe(Itemlist=>this.items=this.items)
  }
  updateitem() 
  {
    console.log("in update");
    this.items.itemName=this.itemName;
    this.items.price=this.price;
    this.items.category=this.category;
    this.items.subCategory=this.subCategory;
    this.items.description=this.description;
    this.items.stockNumber=this.stockNumber;
    this.items.manufacturer=this.manufacturer;
    this.items.remarks=this.remarks;
    this.sellerService.updateitems(this.items).subscribe(Itemlist=>this.items=this.items);
  }


}
