import { Component, inject } from '@angular/core';
import {
  MatDialogRef,
  MatDialogContent,
  MatDialogActions,
  MAT_DIALOG_DATA
} from '@angular/material/dialog';

@Component({
  selector: 'app-dialog-activity-description',
  imports: [MatDialogContent, MatDialogActions],
  templateUrl: './dialog-activity-description.html',
  styleUrl: './dialog-activity-description.css',
})
export class DialogActivityDescription {
  private dialog = inject(MatDialogRef<DialogActivityDescription>);
  data = inject(MAT_DIALOG_DATA);
  close() {
    this.dialog.close();
  }

}
