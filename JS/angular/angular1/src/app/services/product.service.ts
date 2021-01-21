import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Product } from '../product/product';
import { Observable, throwError } from 'rxjs';
import { tap,catchError } from 'rxjs/operators';

@Injectable()
export class ProductService {
  jsonPath = "http://localhost:3000/products";

  constructor(private http:HttpClient) { }

  getProducts(categoryId:number):Observable<Product[]>{
    let newPath = this.jsonPath;

    if(categoryId){
      newPath += "?categoryId="+categoryId
    }
    return this.http.get<Product[]>(newPath).pipe(
      tap(data=>console.log(JSON.stringify(data))),
      catchError(this.handleError)
    );
  }
  handleError(err: HttpErrorResponse){
    let errorMessage;

    if(err.error instanceof ErrorEvent){
      errorMessage = "Bir hata oluştu "+err.message
    }else{
      errorMessage = "sistemsel bir hata"
    }
    return throwError(errorMessage);
  }
}
