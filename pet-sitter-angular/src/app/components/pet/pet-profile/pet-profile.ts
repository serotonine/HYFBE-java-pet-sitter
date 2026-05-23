import { Component, input } from '@angular/core';
import { Pet } from '@app/models/pet.model';

@Component({
  selector: 'app-pet-profile',
  imports: [],
  templateUrl: './pet-profile.html',
  styleUrl: './pet-profile.css',
})
export class PetProfile {
  pet = input<Pet>();

}
