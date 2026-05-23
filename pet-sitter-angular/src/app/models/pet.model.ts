export interface Pet {
  id: number;
  name: string;
  type: PetType;
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