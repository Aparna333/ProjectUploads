import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { from, Observable } from 'rxjs';
import { Cart, Buyer } from './items';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl='http://localhost:8093/buyers';//add buyer
  private baseUrl1='http://localhost:8096/item/seller/1/items';//add items in items depends on sellerId
  private baseUrl3='http://localhost:8096';//add seller, delete items in seller

  constructor(private http: HttpClient) { }
//Buyer
  getItems(itemName: string) : Observable<any> {
    console.log(itemName);
    return this.http.get(`${this.baseUrl3}/item/get/${itemName}`);
  }
  addToCart(cart:Cart):Observable<any> {
    return this.http.post(`http://localhost:8999/cart/1/add`,cart);
  }

displayCartItems() : Observable<any>{
 return this.http.get(`http://localhost:8093/cart/1/getAll`);
}

addbuyer(Buyer:object):Observable<any>
{  
 console.log("in last ts");
 console.log(Buyer);
 return this.http.post(`${this.baseUrl}`,Buyer);
}

login(loginPayload) : Observable<any> {
  return this.http.post('http://localhost:8899/' + 'token/generate-token', loginPayload);
}
//seller
additems(Item:object):Observable<any> 
{ 
  console.log(Item);
  return this.http.post(`${this.baseUrl1}`,Item);
}

deleteitem(itemId:number):Observable<any>
{
  console.log("enter to delete");
  return this.http.delete(`${this.baseUrl3}/item/${itemId}/delete`)
}

updateitems(Item:object):Observable<any> 
{ 
  console.log(Item);
  console.log("in service");
  return this.http.put(`http://localhost:8096/item/sellers/1/items/1`,Item)
}

addseller(Seller:object):Observable<any>
{ 
  console.log("in sellerservice method");
  console.log(Seller);
  return this.http.post(`${this.baseUrl3}/seller`,Seller);
}

}


