import { Component, input, output, inject } from '@angular/core';
// Styling.
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
 // Model.
 import { Pet, PetRequest } from '@app/models/pet.model';
 import { PetTypeSelect } from '../../pet-type-select/pet-type-select';

@Component({
  selector: 'app-pet-form',
  imports: [ 
    ReactiveFormsModule,
    MatCardModule,
    MatButtonModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
  PetTypeSelect],
  styleUrl: './pet-form.css',
  templateUrl: './pet-form.html',
})
export class PetForm {
  submitted = output<PetRequest>();
  pet = input<Pet | null >(null);
petForm = new FormGroup({
    name: new FormControl('', [Validators.required]),
    type: new FormControl<number | null>(null, [Validators.required]),
    age: new FormControl('', [Validators.required]),
    comment: new FormControl('', [Validators.required])
  });

  ngOnInit(){
    // this.petForm.valueChanges.subscribe(val => console.log(val));

    const pet = this.pet();
    if(pet){
      this.petForm.patchValue({
        name:pet?.name,
        type:Number(pet?.type.id),
        age:String(pet?.age),
        comment:pet?.comment,
      })
    }
  }
  
onSubmit(): void {
  if(this.petForm.invalid) return;
  const pet= {
    name: this.petForm.controls.name.value!,
    age: Number(this.petForm.controls.age.value!),
    type:Number(this.petForm.controls.type.value!),
    comment:this.petForm.controls.comment.value!,
  }
  this.submitted.emit(pet);
}

}
