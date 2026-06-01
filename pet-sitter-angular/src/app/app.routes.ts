import { Routes } from '@angular/router';
import { PlanningComponent } from './components/planning/planning.component';
import { RegisterComponent } from './components/auth/register/register.component';

export const routes: Routes = [
  { path: '',   redirectTo: '/planning', pathMatch: 'full' },
  {
    path: 'planning',
    component:PlanningComponent,
  },
   {
    path: 'auth/login',
    title: 'Login',
    loadComponent: () => import('./components/auth/login/login.component').then(m => m.LoginComponent) 
  },
  {
    path: 'auth/register',
    title: 'Register',
    component:RegisterComponent,
  },
  {
    path: 'user/customer/:id',
    title: 'Customer',
    loadComponent: () => import('./components/customer/customer/customer').then(m => m.CustomerComponent) 
  },
];
