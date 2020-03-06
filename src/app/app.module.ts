import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { DisplaycartComponent } from './displaycart/displaycart.component';
import { SearchproductComponent } from './searchproduct/searchproduct.component';
import { NavbarComponent } from './navbar/navbar.component'; 
import { SellerComponent } from './seller/seller.component';
import { SellersignupComponent } from './sellersignup/sellersignup.component';
import { BuyersignupComponent } from './buyersignup/buyersignup.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductDetailsComponent,
    DisplaycartComponent,
    SearchproductComponent,
    NavbarComponent,
    SellerComponent,
    SellersignupComponent,
    BuyersignupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
