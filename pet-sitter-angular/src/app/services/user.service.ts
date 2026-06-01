import { Injectable, signal, computed, inject } from '@angular/core';
import { HttpRequestService } from './httpRequests/http-request.service';

import { Customer, User} from '@app/models/user.model';

@Injectable({
  providedIn: 'root',
})
export class UserService {
private httpRequest = inject(HttpRequestService)
  private user = signal<User | null>(null);
 customer = signal<Customer | null>(null);

  setUser(user:User){
    this.user.set(user);
  };

  readonly getUser = this.user.asReadonly();
  readonly getId = computed(() => this.user()?.id ?? null);
  readonly getEmail = computed(() => this.user()?.email ?? null);
  readonly getRole = computed(() => this.user()?.role ?? null);
  readonly getInitial = computed(() => this.user()?.email?.substring(0,1).toUpperCase()  ?? null);

  clearUser(){
    this.user.set(null);
    this.customer.set(null);
  }
  // Customer
  getCustomer():void{
    if(!this.getUser() || this.getRole() != 'CUSTOMER'){
      return;
    }
   this.httpRequest.getCurrentCustomer().subscribe({
      error: (err) => console.log(err),
      next: (customer) => {
        this.customer.set(customer);
      },
    });
   
  }
  /* if(this.user()){

  } */
 
  
}
