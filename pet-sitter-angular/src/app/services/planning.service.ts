import { Injectable } from '@angular/core';
// Interfaces.
import { Activity } from '@app/models/activity.model';
import { PetBasic } from '@app/models/pet.model';
import { EmployeeBasic } from '@app/models/user.model';

@Injectable({
  providedIn: 'root',
})
export class PlanningService {

  getWeeks(data: any[]): Map<string, Map<string, Activity[]>> {

    const weeks = new Map<string, Map<string, Activity[]>>();

    const activities: Activity[] = this.parseActivities(data);
    activities.forEach((activity) => {
      const { start } = activity;
      const _start = new Date(start);
      const index = _start.toISOString().split('T')[0];

      const week = this.getMonday(_start);
      // const weekDays =
      const key = week.toISOString().split('T')[0];
      if (!weeks.get(key)) {
       
        const days = new Map<string, Activity[]>();
        for(let i=0; i<7; i++){
         const next = this.getNextDay(week, i);
         const k = next.toISOString().split('T')[0];
           
        days.set(k,[]);
        }
       
         weeks.set(key, days);
        
      }
     weeks.get(key)?.get(index)?.push(activity);
     
    });
    return weeks;
  }

  getMonday(date: Date): Date {
    const d = new Date(date);
    d.setDate(d.getDate() - (d.getDay() || 7) + 1);
    return d;
  }
  getNextDay(week: Date, nb: number): Date {
    const next = new Date(week);
    next.setDate(week.getDate() + nb);
    return next;
  }
  // Methods.
  private parseActivities(data: any[]): Activity[] {
    const activities: Activity[] = [];
    data.forEach((item) => {
      const pets: PetBasic[] =
        item.pets?.map(
          (pet: any): PetBasic => ({
            id: pet.id,
            name: pet.name,
            type: pet.type,
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
      activities.push({
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
    return activities;
  }
}
