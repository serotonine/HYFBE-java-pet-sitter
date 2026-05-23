import { EmployeeBasic } from "./user.model";
import { PetBasic } from "./pet.model";

export interface Activity{
  id: number;
  title: string;
  description: string;
  start: string;
  end: string;
  duration: number;
  max:number;
  pets: PetBasic[];
  employee: EmployeeBasic[];
}

