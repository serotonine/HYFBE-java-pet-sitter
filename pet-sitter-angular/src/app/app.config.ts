import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import { MAT_FORM_FIELD_DEFAULT_OPTIONS } from '@angular/material/form-field';
// Interceptor.
/**
 * It's an injection token built into Angular
 * essentially a key that Angular uses to look up all registered interceptors in its pipeline.
 */
import { HTTP_INTERCEPTORS, provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { AuthInterceptor } from './auth/auth.interceptor';

import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideHttpClient(withInterceptorsFromDi()),
    {
      provide: MAT_FORM_FIELD_DEFAULT_OPTIONS,
      useValue: { appearance: 'outline' }, // mat-form-field outline style
    },
    // "When  HTTP_INTERCEPTORS is called, return AuthInterceptor"
    {
      provide: HTTP_INTERCEPTORS, // the key (what to look for)
      useClass: AuthInterceptor, // the value (what to give)
      multi: true, // don't replace others, add to the list
    },
  ],
};
