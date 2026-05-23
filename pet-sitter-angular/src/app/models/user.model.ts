import { Pet } from "./pet.model";

// Roles
export enum Role {
  admin = 'ADMIN',
  customer = 'CUSTOMER',
  employee = 'EMPLOYEE'
}

// User.
export interface User{
  id?:string;
  email?:string;
  role?:Role;
}

// Customer.
export interface Customer{
  id:string | null;
  name:string| null;
  email:string| null;
  address:string| null;
  tel:string| null;
  pets:Pet[]| [];
}
// Employee.
export interface EmployeeBasic {
  id: number;
  name: string;
}
