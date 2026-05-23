import { Injectable, signal, computed } from '@angular/core';

import { User} from '@app/models/user.model';

@Injectable({
  providedIn: 'root',
})
export class UserService {

  private user = signal<User | null>(null);

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
  }
 
  
}
