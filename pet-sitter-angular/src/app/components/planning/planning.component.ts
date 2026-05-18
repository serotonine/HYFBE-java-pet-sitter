import { Component, inject } from '@angular/core';
import { HttpRequestService } from '../../services/httpRequests/http-request.service';
// Pipes.
import { DatePipe} from '@angular/common';
// Interfaces.
import { Activity } from '../../models/activity.model';
import { PetBasic } from '../../models/pet.model';
import { EmployeeBasic } from '../../models/employee.model';
// Components.
import { MatCardModule } from '@angular/material/card';
import {MatChipsModule} from '@angular/material/chips';
@Component({
  selector: 'app-planning',
  imports: [MatCardModule,MatChipsModule, DatePipe],
  templateUrl: './planning.component.html',
  styleUrl: './planning.component.css',
})
export class PlanningComponent {
  private httpRequest = inject(HttpRequestService);
  public activities: Activity[] = [];
  ngOnInit() {
    this.httpRequest.getActivities().subscribe({
      next: (data) => this.parseActivities(data),
      error: (err) => console.error(err),
    });
  }
  // Methods.
  private parseActivities(data: any[]): void {
    data.forEach((item) => {
      const pets: PetBasic[] =
        item.pets?.map(
          (pet: any): PetBasic => ({
            id: pet.id,
            name: pet.name,
            breed: pet.type,
            age: pet.age,
          }),
        ) ?? [];
      const employees: EmployeeBasic[] =
        item.employees?.map(
          (employee: any): EmployeeBasic => ({
            id: employee.id,
            name: employee.name,
          }),
        ) ?? [];
      this.activities.push({
        id: item.id,
        title: item.name,
        description: item.type.description,
        start: item.startDate,
        end: item.endDate,
        duration: item.type.durationInMinutes,
        max: item.type.maxDog,
        pets: pets,
        employee: employees,
      });
    });
  }
  public getRemainingPlaces(activity: Activity): string {
  const remainingPlaces:number = activity.max - activity.pets.length;
  switch(remainingPlaces){
    case 0:
      return "Complete!"
      break;
      case 1:
        return `Still ${remainingPlaces} place!`
        break;
        default:
          return `Still ${remainingPlaces} places!`
  }
}
}
