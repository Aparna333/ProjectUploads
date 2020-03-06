import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Seller } from '../items';

@Component({
  selector: 'app-sellersignup',
  templateUrl: './sellersignup.component.html',
  styleUrls: ['./sellersignup.component.css']
})
export class SellersignupComponent implements OnInit {

  
	sellerUserName:String;
	 password:String;
	 companyName:String;
	 companyDetails:String;
   postalAddress:String;
   	website:String;
   email:String;
    contactNumber:String;
  constructor(private service:ProductService) { }
  seller:Seller;

  addseller()
  {
    this.seller=new Seller();
    this.seller.sellerUserName=this.sellerUserName;
    this.seller.password=this.password;
    this.seller.email=this.email;
    this.seller.contactNumber=this.contactNumber;
    this.seller.postalAddress=this.postalAddress;
    this.seller.companyName=this.companyName;
    this.seller.companyDetails=this.companyDetails;
    this.seller.website=this.website;
    console.log("in sellerts" + this.seller);
    this.service.addseller(this.seller).subscribe(Seller=>this.seller=Seller);
  }

  ngOnInit(): void {
  }

}


