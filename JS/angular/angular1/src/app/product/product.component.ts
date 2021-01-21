import { Component, OnInit } from '@angular/core';
import { Product } from './product';
import { ProductService } from '../services/product.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
  providers: [ProductService]
})
export class ProductComponent implements OnInit {
  title: string = 'Ürünler';
  products: Product[] | undefined;

  constructor(
    private productService:ProductService,
    private activatedRoute:ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.productService.getProducts(params["categoryId"]).subscribe(data=>{
        this.products = data;
      })
    })
  }

  addToCart(product:Product):void {
    alert(product.name + " sepete eklendi");
  }
}
