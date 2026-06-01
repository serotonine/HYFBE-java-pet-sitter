import { Component, input, inject} from '@angular/core';
// Dialog.
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { DialogActivityDescription } from '../shared/dialog/dialog-activity-description/dialog-activity-description';
import { DialogActivityBookPet } from '../shared/dialog/dialog-activity-book-pet/dialog-activity-book-pet';

// Components.
import { MatCardModule } from '@angular/material/card';
import { MatChipsModule } from '@angular/material/chips';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatButtonAppearance } from '@angular/material/button';
// Models.
import { Activity as ActivityModel } from '@app/models/activity.model';
import { Pet, PetBasic } from '@app/models/pet.model';
// Pipes
import { DatePipe } from '@angular/common';
import { MatAnchor } from "@angular/material/button";

@Component({
  selector: 'app-activity',
  imports: [MatButtonModule, MatDialogModule, MatCardModule, MatChipsModule, MatIconModule, DatePipe, MatAnchor],
  templateUrl: './activity.html',
  styleUrl: './activity.css',
})
export class Activity {
  activity = input.required<ActivityModel>();
  pets = input<Pet[] | null>();
  private dialog: MatDialog = inject(MatDialog);
 
  displayRemainingPlaces(): string {
    const remainingPlaces: number = this.getRemainingPlaces();
      
    switch (remainingPlaces) {
      case 0:
        return 'Complete!';
        break;
      case 1:
        return `Still ${remainingPlaces} place!`;
        break;
      default:
        return `Still ${remainingPlaces} places!`;
    }
  }
   getRemainingPlaces(): number {
      return this.activity()?.max - this.activity()?.pets.length;
    }

  openDescription() {
    this.dialog.open(DialogActivityDescription, {
      data: {
        title: 'Description',
        content: this.activity().description
      },
    });
  }
  addPetToActivity(){
    this.dialog.open(DialogActivityBookPet,{
      data:{
        title: this.activity().title,
        duration:this.activity().duration,
        start: this.activity().start,
        end: this.activity().end,
        pets:this.pets()
      }
    });
  }
}
