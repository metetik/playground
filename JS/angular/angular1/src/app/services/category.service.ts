import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Category } from '../category/category';
import { Observable, throwError } from 'rxjs';
import { tap,catchError } from 'rxjs/operators';

@Injectable()
export class CategoryService {
  jsonPath = "http://localhost:3000/categories";

  constructor(private http:HttpClient) { }

  getCategories():Observable<Category[]>{
    return this.http.get<Category[]>(this.jsonPath).pipe(
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
