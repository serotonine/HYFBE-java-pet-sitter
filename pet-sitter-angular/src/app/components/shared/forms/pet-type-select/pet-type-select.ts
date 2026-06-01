import { Component, inject, signal, input } from '@angular/core';
import {MatSelectModule} from '@angular/material/select';
import {MatFormFieldModule} from '@angular/material/form-field';
import { FormControl } from '@angular/forms';
import { ControlValueAccessor } from '@angular/forms';
import { HttpRequestPetService } from '@app/services/httpRequests/htt-request-pet.service';
import { PetType } from '@app/models/pet.model';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-pet-type-select',
  imports: [ReactiveFormsModule,MatSelectModule, MatFormFieldModule],
  templateUrl: './pet-type-select.html',
})
export class PetTypeSelect implements ControlValueAccessor{
  
  control= input.required<FormControl>();
  private httpRequest = inject(HttpRequestPetService);
  error= signal<string>('');
  petTypes = signal<PetType[]>([]);
  value: any = null;
  onChange = (val: any) => {};
  onTouched = () => {};
  ngOnInit(){
    this.httpRequest.getPetTypes().subscribe({
      error: (err) => console.error(err) ,
      next: (petTypes:PetType[]) => this.petTypes.set(petTypes)
    });
  }

  writeValue(val: any) { this.value = val; }
  registerOnChange(fn: any) { this.onChange = fn; }
  registerOnTouched(fn: any) { this.onTouched = fn; }

}
