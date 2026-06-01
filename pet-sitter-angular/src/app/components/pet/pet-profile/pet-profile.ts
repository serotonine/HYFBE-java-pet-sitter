import { Component, input, output, inject, signal } from '@angular/core';
import { Pet, PetRequest } from '@app/models/pet.model';
import { ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatButton } from '@angular/material/button';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';

// Services.
import { HttpRequestPetService } from '@app/services/httpRequests/htt-request-pet.service';
// Dialog
import { PetDialog } from '@app/components/shared/dialog/pet.dialog/pet.dialog';

@Component({
  selector: 'app-pet-profile',
  imports: [ReactiveFormsModule, MatDialogModule, MatCardModule, MatButton],
  templateUrl: './pet-profile.html',
  styleUrl: './pet-profile.css',
})
export class PetProfile {
  pet = input<Pet | undefined>();
  deletedPet = output<number>();

  // httpRequest
  private httpRequest: HttpRequestPetService = inject(HttpRequestPetService);
  protected error = signal<string>('');
  protected isEditing = signal<boolean>(false);
  protected _pet = signal<Pet | undefined>(undefined);
  // Dialog
  private dialog: MatDialog = inject(MatDialog);

  ngOnInit() {
    if (this.pet()) {
      this._pet.set(this.pet());
    }
  }

  //Event handlers
  updatePet() {
    /**
     *{
        "name": "string",
        "typeId": 0,
        "age": 0,
        "comment": "string"
      }
     */
    const ref = this.dialog.open(PetDialog, {
      data: {
        title: `Edit ${this._pet()?.name}`,
        request: 'PATCH',
        pet: this._pet(),
      },
    });
    ref.afterClosed().subscribe((result) => {
      if (!result) return;
      const { name, id, age, type, comment } = result.response;

      console.dir(result.response);
      const pet: Pet = { name, id, age, type, comment };
      this._pet.update((pet) => ({
        ...pet!,
        name,
        id,
        age,
        type,
        comment,
      }));
    });
  }

  deletePet(id: number | undefined) {
    if (id) {
      this.httpRequest.deletePet(Number(id)).subscribe({
        error: (err: Error) => console.log(err),
        next: (response) => {
          this.deletedPet.emit(id)
        },
      });
    }
  }
}
