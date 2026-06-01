import { Injectable } from '@angular/core';
import {
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';

@Injectable({
  providedIn: 'root',
})
export class FormService {

  customerForm = new FormGroup({
    name: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email]),
    tel: new FormControl('', [
      Validators.required,
      Validators.pattern('[+]?[0-9\\s\\-]{7,15}'),
    ]),
    address: new FormControl('', Validators.required),
  });
  petForm = new FormGroup({
    name: new FormControl('', [Validators.required]),
    type: new FormControl('', [Validators.required]),
    age: new FormControl('', [Validators.required]),
    comment: new FormControl('', [Validators.required])
  });
  
}
