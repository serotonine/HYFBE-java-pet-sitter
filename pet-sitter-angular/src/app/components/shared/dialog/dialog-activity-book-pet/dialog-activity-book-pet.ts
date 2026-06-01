import { Component, inject } from '@angular/core';
import { ReactiveFormsModule, FormGroup, FormControl, FormArray } from '@angular/forms';
import {MatCheckboxModule} from '@angular/material/checkbox'
import { MatButtonModule } from '@angular/material/button';
import { DatePipe } from '@angular/common';



import {
  MatDialogRef,
  MatDialogContent,
  MatDialogActions,
  MAT_DIALOG_DATA
} from '@angular/material/dialog';

@Component({
   selector: 'app-dialog-activity-book-pet',
  imports: [ ReactiveFormsModule, MatDialogContent, MatDialogActions, MatCheckboxModule, MatButtonModule, DatePipe],
   templateUrl: './dialog-activity-book-pet.html',
  styleUrl: './dialog-activity-book-pet.css',
})
export class DialogActivityBookPet {
   private dialog = inject(MatDialogRef<DialogActivityBookPet>);
  data = inject(MAT_DIALOG_DATA);
  petForm = new FormGroup({
    pets: new FormArray<FormControl<boolean>>([])
  });
onSubmit(){

  console.log("pets");
  console.log(this.data.pets);
  console.log(this.petForm.controls);
}

 
  close() {
    this.dialog.close();
  }
}
