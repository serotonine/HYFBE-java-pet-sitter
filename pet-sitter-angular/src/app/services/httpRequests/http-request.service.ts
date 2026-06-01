import { environment } from '../../../environments/environment.development';
import { Injectable, OnInit, inject, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, map, throwError, Observable } from 'rxjs';
import { HttpParams } from '@angular/common/http';

// Model.
import { Customer } from '@app/models/user.model';

interface LoginResponse {
  token: string;
}

// Plain Service — you call it yourself
@Injectable({
  providedIn: 'root',
}) // Inject this class globaly.
export class HttpRequestService {
  private _httpClient = inject(HttpClient);
  private _apiUrl = environment.apiUrl;
  

  /* //////////////////////////////// GET  //////////////////////////////// */
  // Retrieve all activities => planning component.
  getActivities() {
    return this._httpClient
      .get<[]>(`${this._apiUrl}activity`)
      .pipe(catchError((error) => throwError(() => new Error(error.message))));
  }
  // Retrieve current customer => /user/customer/id
  getCurrentCustomer(){
    return this._httpClient
      .get<Customer>(`${this._apiUrl}customer/user`)
      .pipe(catchError((error) => throwError(() => new Error(error.message))));
  
  }

  /* //////////////////////////////// POST //////////////////////////////// */
  // Login.
  login(options:{email:string, pwd:string}){
    const params = new  HttpParams({fromObject: options}) ;
    // post(url, body, options)
    return this._httpClient
      .post<LoginResponse>(`${this._apiUrl}user/login`,null,{params} )
      .pipe(
        map((response) => response.token),
        catchError((err) => throwError(() => err.error.error)
        ));
  }
  /* //////////////////////////////// PATCH //////////////////////////////// */
  updateCustomer(id: number, data: Partial<Customer>): Observable<Customer>{
    // console.log(`${this._apiUrl}customer/${id}`);
    // console.dir(data);
  return this._httpClient
  .patch<Customer>(`${this._apiUrl}customer/${id}`, data)
  .pipe(
    catchError((err) => throwError(() => err))
  );
}

  //const data = this.customerForm.getRawValue();

 /* 
 // UPDATE.
  updateList(type: string, id: number, options: {}) {
    const _options = Object.values(options).filter((value) => typeof value ==='string' && value.length >=1 ).join('/');
    
    return this._httpClient
      // $type,$id, $user,$fr,$nl,$perf=null,$imperf=null
      .put(`https://serotonine.alwaysdata.net/restapi/${type}/1/${id}/${_options}`, {
        observe: 'response',
      })
      .pipe(catchError((error) => throwError(() => new Error(error.message))));
  }
  */
/*
  // DELETE.
  delete(type: string, id: number) {
    const options = {
      params: new HttpParams().set('request', `${type}/1/${id}`),
    };
    return this._httpClient
      .delete(this._apiUrl, options)
      .pipe(catchError((error) => throwError(() => new Error(error.message))));
  } */
}
