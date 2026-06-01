import { Component, input, inject, signal } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { Customer } from '@app/models/user.model';
import { FormGroup } from '@angular/forms';
// Services.
import { HttpRequestService } from '@app/services/httpRequests/http-request.service';
import { FormService } from '@app/services/forms/form.service';
// Form component.
import { UserForm } from '@app/components/shared/forms/user-form/user-form';
@Component({
  selector: 'app-customer-profile',
  imports: [ReactiveFormsModule, MatCardModule, UserForm],
  templateUrl: './customer-profile.html',
  styleUrl: './customer-profile.css',
})
export class CustomerProfile {
  /**
   * All the Customer CRUD logic (display Customer - Edit customer).
   * The datas are retrieved in Parent Customer component.
   */
  customer = input<Customer | undefined>();
  customerForm = input.required<FormGroup>();
  // Reactive forms models.
  private formService : FormService = inject(FormService);
  // httpRequest
  private httpRequest: HttpRequestService = inject(HttpRequestService);
  // The switch Cutomer/ Form.
  protected _customer = signal<Customer | undefined>(undefined);
  protected error = signal<string>('');
  protected isEditing = signal<boolean>(false);

  ngOnInit(){
    this._customer.set(this.customer());

    console.dir(this._customer());
    console.dir(this.customer());
  }
  
  onSubmitCustomer():void {
    // Errors.
    if (this.customerForm().invalid) {
      this.customerForm().markAllAsTouched(); // déclenche l'affichage des erreurs mat
      return;
    }
    const data = this.customerForm().getRawValue();
    const id = Number(this.customer()?.id);
    this.httpRequest.updateCustomer(id, data).subscribe({
      error: (err) => this.error.set(err),
      next: (customer) =>{
        console.log("Updated customer");
        console.dir(customer);
        this._customer.set(customer);
        this.isEditing.update(prev => !prev);
      }
    });
  }
}
