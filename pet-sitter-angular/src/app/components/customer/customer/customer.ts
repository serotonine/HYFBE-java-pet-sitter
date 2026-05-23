import { Component, inject, signal } from '@angular/core';
import {
  FormArray,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
// Service.
import { HttpRequestService } from '@app/services/httpRequests/http-request.service';
// Styling.
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
// Component.
import { CustomerProfile } from '../profile/customer-profile/customer-profile';
import { PetProfile } from '@app/components/pet/pet-profile/pet-profile';
// Data
import { Customer } from '@app/models/user.model';
import { Pet } from '@app/models/pet.model';

@Component({
  selector: 'app-customer',
  imports: [
    ReactiveFormsModule,
    MatCardModule,
    MatButtonModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    CustomerProfile,
    PetProfile
  ],
  templateUrl: './customer.html',
  styleUrl: './customer.scss',
})
export class CustomerComponent {
  // Inject.
  private httpRequest: HttpRequestService = inject(HttpRequestService);
  // Forms
  // Customer.
  customerForm = new FormGroup({
    name: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email]),
    tel: new FormControl('', [
      Validators.required,
      Validators.pattern('[+]?[0-9\\s\\-]{7,15}'),
    ]),
    address: new FormControl('', Validators.required),
  });
  // Pet.
  petForms = new FormArray<FormGroup>([]);
  
  // Template variables
  protected error = signal<string>('');
  protected customer = signal<Customer | null>(null);
  // Signal.
  protected isEditingCustomer = signal<boolean>(false);
  protected isEditingPet = signal<boolean>(false);

  ngOnInit() {
    this.httpRequest.getCurrentCustomer().subscribe({
      error: (err) => this.error.set(err),
      next: (customer) => {
        this.customer.set(customer);
        // console.dir(customer);
        const { name, email, address, tel } = customer;
        this.customerForm.patchValue({ name, email, address, tel });
         for(const pet of customer.pets){
          this.addPetForm(pet);
        }
      },
    });
  }
  // PATCH
  // Customer.
  onSubmitCustomer() {
    // Errors.
    if (this.customerForm.invalid) {
      this.customerForm.markAllAsTouched(); // déclenche l'affichage des erreurs mat
      return;
    }
    const data = this.customerForm.getRawValue();
    const id = Number(this.customer()?.id);
    this.httpRequest.updateCustomer(id, data).subscribe({
      error: (err) => this.error.set(err),
      next: (customer) =>{
        this.customer.set(customer);
        this.isEditingCustomer.update(prev => !prev);
       
      }
    });
  }
  // Pet
   onSubmitPet(petId: number) {
  const form = this.getPetForm(petId);
  if (form.invalid) {
    form.markAllAsTouched();
    return;
  }
  const data = form.getRawValue();
  /* this.httpRequest.updatePet(petId, data).subscribe({
    error: (err) => this.error.set(err),
    next: () => this.isEditingPet.update(prev => !prev);
  }); */
}
  
  // POST
  addPet(){
    const id = Number(this.customer()?.id);

  }
  getPetForm(id: number): FormGroup {
  const index = this.customer()!.pets!.findIndex(p => p.id === id);
  return this.petForms.at(index) as FormGroup;
}
  // Populate petForms.
  addPetForm(pet: Pet) {
  this.petForms.push(new FormGroup({
    name: new FormControl(pet.name, [Validators.required]),
    age: new FormControl(pet.age, [Validators.required]),
    type: new FormControl(pet.type.id, [Validators.required]),
    comment: new FormControl(pet.comment),
  }));
}
 
}
