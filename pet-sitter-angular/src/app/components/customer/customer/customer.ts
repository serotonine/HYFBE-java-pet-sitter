import { Component, inject, signal } from '@angular/core';
// Service.
import { HttpRequestService } from '@app/services/httpRequests/http-request.service';
import { FormService } from '@app/services/forms/form.service';
// TO IF NEEDED
//import { UserService } from '@app/services/user.service';
// Material Design Styling.
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
// Component.
import { CustomerProfile } from '../profile/customer-profile/customer-profile';
import { PetProfile } from '@app/components/pet/pet-profile/pet-profile';
// Models.
import { Customer } from '@app/models/user.model';
import { Pet } from '@app/models/pet.model';
import { PetDialog } from '@app/components/shared/dialog/pet.dialog/pet.dialog';

@Component({
  selector: 'app-customer',
  imports: [
    MatDialogModule,
    MatCardModule,
    MatButtonModule,
    CustomerProfile,
    PetProfile,
  ],
  templateUrl: './customer.html',
  styleUrl: './customer.scss',
})
export class CustomerComponent {
  // Inject.
  private httpRequest: HttpRequestService = inject(HttpRequestService);
  private formService: FormService = inject(FormService);
  
  /**
   * this.dialog.open(DialogForm, {
  data: { title: 'Add a pet' },   // données passées au dialog
  width: '500px',                  // largeur
  height: '400px',                 // hauteur
  maxWidth: '90vw',                // largeur max
  minWidth: '300px',               // largeur min
  panelClass: 'my-dialog',        // classe CSS custom
  disableClose: true,              // empêche fermeture en cliquant dehors
  autoFocus: true,                 // focus auto sur premier élément
  backdropClass: 'my-backdrop',   // classe du fond
  position: { top: '100px' },     // position custom
  enterAnimationDuration: '300ms',
  exitAnimationDuration: '200ms',
});
   */
  private dialog: MatDialog = inject(MatDialog);
  customerForm = this.formService.customerForm;

  // Template variables
  protected error = signal<string>('');
  protected customer = signal<Customer | undefined>(undefined);
  // Signal.
  protected isEditingPet = signal<boolean>(false);

  ngOnInit() {
    // TODO IF NEEDED => transfer all logic on UserService.
    this.httpRequest.getCurrentCustomer().subscribe({
      error: (err) => this.error.set(err),
      next: (customer) => {
        this.customer.set(customer);
        const { name, email, address, tel } = customer;
        this.customerForm.patchValue({ name, email, address, tel });
      },
    });
  }

  // Open Add Pet Dialog
  addPet() {
    const id = Number(this.customer()?.id);
    const ref = this.dialog.open(PetDialog, {
      data: {
        title: 'Add a new pet',
        request: 'POST',
        customerId: id,
      },
    });
    ref.afterClosed().subscribe((result) => {
      if(!result) return;
      const { name, id, age, type, comment } = result.response;
      const pet: Pet = { name, id, age, type,comment};
      this.customer.update((customer) => ({
        ...customer!,
        pets: [...customer!.pets, pet],
      }));
     
    });
  }
  // Emited 
  onDeletedPet(id:number){
    const petList = this.customer()?.pets.filter(
      pet => pet.id != id
    )
      this.customer.update((customer) => ({
        ...customer!,
        pets: petList!,
      }));

  }
}
