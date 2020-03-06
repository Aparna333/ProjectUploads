import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Buyer } from '../items';

@Component({
  selector: 'app-buyersignup',
  templateUrl: './buyersignup.component.html',
  styleUrls: ['./buyersignup.component.css']
})
export class BuyersignupComponent implements OnInit {
  userName:String;
  password:String;
  email:String;
  mobileNumber:String;
  buyer:Buyer;
  constructor(private service:ProductService) { }
  addbuyer()
  {
    this.buyer=new Buyer();
    this.buyer.userName=this.userName;
    this.buyer.password=this.password;
    this.buyer.email=this.email;
    this.buyer.mobileNumber=this.mobileNumber;
    console.log("In Service ts");
    console.log(this.buyer);
    this.service.addbuyer(this.buyer).subscribe(newbuyer=>this.buyer=newbuyer);
  }
  ngOnInit(): void {
  }

}
