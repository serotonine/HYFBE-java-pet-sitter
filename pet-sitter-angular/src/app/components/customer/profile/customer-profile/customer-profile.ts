import { Component, input  } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { Customer } from '@app/models/user.model';

@Component({
  selector: 'app-customer-profile',
  imports: [MatCardModule],
  templateUrl: './customer-profile.html',
  styleUrl: './customer-profile.css',
})
export class CustomerProfile {
  customer = input<Customer>();

}
