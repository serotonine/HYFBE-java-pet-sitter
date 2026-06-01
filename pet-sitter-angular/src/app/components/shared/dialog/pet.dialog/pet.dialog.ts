import { Component, inject, signal } from '@angular/core';
import {
  MatDialogRef,
  MatDialogTitle,
  MatDialogContent,
  MatDialogActions,
  MAT_DIALOG_DATA,
} from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { PetForm } from '../../forms/pet-form/pet-form/pet-form';
import { PetRequest } from '@app/models/pet.model';
// Service
import { HttpRequestPetService } from '@app/services/httpRequests/htt-request-pet.service';
import { MatError } from '@angular/material/form-field';

@Component({
  selector: 'app-dialog-form',
  imports: [
    MatDialogTitle,
    MatDialogContent,
    MatDialogActions,
    MatButtonModule,
    PetForm,
    MatError,
  ],
  templateUrl: './pet.dialog.html',
  styleUrl: './pet.dialog.css',
})
export class PetDialog {
  // Dialog
  private dialog = inject(MatDialogRef<PetDialog>);
  data = inject(MAT_DIALOG_DATA);
  // Request
  private httpRequest: HttpRequestPetService = inject(HttpRequestPetService);
  // Error
  protected error = signal<string | null>(null);

  onSubmit(pet: PetRequest): any {
    pet.customer = this.data?.customerId;
    
    switch (this.data?.request) {
      case 'POST':
        /**
       * Back end Request body
       * {
        "name": "Riri",
        "customer": 7,
        "type": 5,
        "age": 5,
        "comment": "Male"
        }
        */
        return this.httpRequest.addPet(pet).subscribe({
          error: (error) => this.error.set(error.message),
          next: (response) => this.dialog.close({ action: 'added', response }),
        });
        break;
        case 'PATCH':
          return this.httpRequest.updatePet(this.data?.pet?.id, pet).subscribe({
          error: (error) => this.error.set(error.message),
          next: (response) => this.dialog.close({ action: 'added', response }),
        });
         
    }
  }

  close() {
    this.dialog.close();
  }
}
