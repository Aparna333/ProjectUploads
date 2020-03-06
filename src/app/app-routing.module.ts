import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { DisplaycartComponent } from './displaycart/displaycart.component';
import { SearchproductComponent } from './searchproduct/searchproduct.component';
import { SellerComponent } from './seller/seller.component';
import { BuyersignupComponent } from './buyersignup/buyersignup.component';
import { SellersignupComponent } from './sellersignup/sellersignup.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
  {path : 'seller',component:SellerComponent},
  {path : 'buyersign',component:BuyersignupComponent},
  {path : 'sellersign',component:SellersignupComponent},
  {path : 'searchproduct',component:SearchproductComponent},
  {path : 'displaycart' , component:DisplaycartComponent},
  {path : 'login', component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
