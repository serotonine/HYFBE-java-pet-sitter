import { Component, inject } from '@angular/core';
// Services
import { HttpRequestService } from '@app/services/httpRequests/http-request.service';
import { PlanningService } from '@app/services/planning.service';
import { UserService } from '@app/services/user.service';
// Pipes.
import { DatePipe, KeyValuePipe} from '@angular/common';
// Interfaces.
import { Activity as ActivityModel } from '@app/models/activity.model';
// Components.
import { MatCardModule } from '@angular/material/card';
import {MatChipsModule} from '@angular/material/chips';
import { Activity } from '../activity/activity';
@Component({
  selector: 'app-planning',
  imports: [MatCardModule, MatChipsModule, DatePipe, KeyValuePipe, Activity],
  templateUrl: './planning.component.html',
  styleUrl: './planning.component.css',
})
export class PlanningComponent {
  private httpRequest = inject(HttpRequestService);
  private planningService = inject(PlanningService);
  // Customer.
  private userService = inject(UserService);
  customer = this.userService.customer;  
 
  // Activities.
  public activities:Map<string, Map<string, ActivityModel[]>>= new Map();
  ngOnInit() {
    this.userService.getCustomer();
    this.httpRequest.getActivities().subscribe({
      next: (data) => {
      this.activities = this.planningService.getWeeks(data);
       // return this.parseActivities(data);
      },
      error: (err) => console.error(err),
    });
  }
}
