import { Routes } from '@angular/router';
import { PlanningComponent } from './components/planning/planning.component';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { CustomerComponent } from './components/customer/customer/customer';

export const routes: Routes = [
  { path: '',   redirectTo: '/planning', pathMatch: 'full' },
  {
    path: 'planning',
    component:PlanningComponent,
  },
   {
    path: 'auth/login',
    title: 'Login',
    component:LoginComponent,
  },
  {
    path: 'auth/register',
    title: 'Register',
    component:RegisterComponent,
  },
  {
    path: 'user/customer/:id',
    title: 'Customer',
    component:CustomerComponent,
  },
];
