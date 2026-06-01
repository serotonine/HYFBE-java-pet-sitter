import { environment } from '../../../environments/environment.development';
import { Injectable, OnInit, inject, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, map, throwError, Observable } from 'rxjs';
import { HttpParams } from '@angular/common/http';

// Model.
import {Pet, PetRequest, PetType } from '@app/models/pet.model';

interface LoginResponse {
  token: string;
}

// Plain Service — you call it yourself
@Injectable({
  providedIn: 'root',
}) // Inject this class globaly.
export class HttpRequestPetService {
  private _httpClient = inject(HttpClient);
  private _apiUrl = `${environment.apiUrl}pet`;

  // GET
  getPetTypes(){
    return this._httpClient
    .get<PetType[]>(`${this._apiUrl}-type`)
    .pipe(catchError(err => throwError(() => err)))
  }
  // POST
  addPet(pet:PetRequest):Observable<PetRequest>{
    //options={}
    //
    // test
    const body= {
      ...pet,
      customer:Number(pet.customer),
      id: Number(pet.id),
      age: Number(pet.age),
      type:Number(pet.type)
    };
    return this._httpClient
    .post<PetRequest>(this._apiUrl, body)
    .pipe(
       catchError((err) => throwError(() => err))
    );
  }
  // PATCH 
  updatePet(petId:string | number,pet: Partial<PetRequest>){
    // AWFUL HACK.
    pet.typeId = pet.type;
    console.log("pet service level: ", pet.typeId)
    return this._httpClient
    .patch<PetRequest>(`${this._apiUrl}/${petId}`, pet)
    .pipe(
      catchError((err) => throwError(() => err))
    );
  }
  // DELETE
  deletePet(petId:string | number):Observable<Pet>{
    return this._httpClient
    .delete<Pet>(`${this._apiUrl}/${petId}`)
    .pipe(
      catchError((err) => throwError(() => err))
    );
  }
}