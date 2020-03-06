export class Item{
    itemId:number;
    category:number;
    subCategory:number;
    price:number;
    manufacturer: String;
    itemName:String;
    description:String;
    stockNumber:number;
    remarks:String;
}
export class Seller{
	 sellerUserName:String;
	 password:String;
	 companyName:String;
	 companyDetails:String;
     postalAddress:String;
	 website:String;
     email:String;
     contactNumber:String;   
}
export class Cart {
    cartId:number;
    itemId:number;
    quantity:number;
    description:String;
   }
   export class Buyer{
     userName:String;
     password:String;
     email:String;
     mobileNumber:String;
  }
