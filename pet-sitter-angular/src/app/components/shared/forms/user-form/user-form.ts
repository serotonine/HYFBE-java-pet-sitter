import { Component, input, output } from '@angular/core';
// Styling.
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { FormGroup } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';


@Component({
  selector: 'app-user-form',
  imports: [ 
    ReactiveFormsModule,
    MatCardModule,
    MatButtonModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule],
  templateUrl: './user-form.html',
})
export class UserForm {
userForm = input.required<FormGroup>();
//@Input() fields!: { name: string; label: string; type: string }[];
submitted = output<void>();
onSubmit(): void {
  this.submitted.emit();
}

}
