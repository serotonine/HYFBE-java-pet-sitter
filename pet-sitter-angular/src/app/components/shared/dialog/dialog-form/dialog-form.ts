import { Component, inject } from '@angular/core';
import {
  MatDialogRef,
  MatDialogTitle,
  MatDialogContent,
  MatDialogActions,
  MAT_DIALOG_DATA
} from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';



@Component({
  selector: 'app-dialog-form',
  imports: [
    MatDialogTitle,
    MatDialogContent,
    MatDialogActions,
    MatButtonModule
  ],
  templateUrl: './dialog-form.html',
  styleUrl: './dialog-form.css',
})
export class DialogForm {
  //form = input<FormGroup>();
  private dialog = inject(MatDialogRef<DialogForm>);
  data = inject(MAT_DIALOG_DATA);
  
  close(){
    this.dialog.close();
  }
}
