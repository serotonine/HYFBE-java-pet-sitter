import { Routes } from '@angular/router';
import { PlanningComponent } from './components/planning/planning.component';

export const routes: Routes = [
  { path: '',   redirectTo: '/planning', pathMatch: 'full' },
  {
    path: 'planning',
    component:PlanningComponent,
  },
];
