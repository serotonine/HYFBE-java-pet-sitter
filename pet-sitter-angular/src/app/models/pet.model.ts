export interface Pet {
  id?: number;
  customer?:number;
  name: string;
  type: PetType;
  age: number;
  comment:string;
}
export interface PetRequest {
  id?: number;
  customer?:number;
  name: string;
  type: number;
  typeId?:number;
  age: number;
  comment:string;
}
export interface PetType{
  id:string;
  name:string;
}

export interface PetBasic {
  id: number;
  name: string;
  type: PetType;
  age: number;
}