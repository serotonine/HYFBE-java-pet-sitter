import { Component, signal, inject, WritableSignal, ProviderToken } from '@angular/core';
// Http requests.
import { HttpRequestService } from '@app/services/httpRequests/http-request.service';
// Auth
import { AuthService } from '@app/auth/auth.service';

// Reactive Form.
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
// Router.
import { Router } from '@angular/router';
// Components
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';


@Component({
  selector: 'app-login',
  imports: [
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  // Http service.
  private httpRequest = inject(HttpRequestService);
  // Authentication.
  private auth = inject(AuthService);
  // Router.
  private router = inject(Router);

  // Reactive values.
  isHidden: WritableSignal<boolean> = signal(true);
  error: WritableSignal<string> = signal('');

  // Login Form.
  loginForm = new FormGroup({
    email: new FormControl('', {
      validators: [Validators.email, Validators.required],
    }),
    password: new FormControl('', {
      validators: [Validators.required],
    }),
  });

  // Handler events.
  login(): void {
    // Errors.
    if (this.loginForm.invalid) {
      this.loginForm.markAllAsTouched(); // déclenche l'affichage des erreurs mat
      return;
    }
    // Values.
    const { email, password } = this.loginForm.value;
    const params = { email: email!, pwd: password! };
    // Fetch service.
    this.httpRequest.login(params).subscribe({
      error: (err) => this.error.set(err),
      next: (token) => {
      if(!token){
        throw new Error("No Token.");
      }
        // LocalStorage.
        this.auth.saveTokens(token);
        // User.
        this.auth.setUserFromToken(token);
        // Redirect to home page.
        this.router.navigate(['/planning']);
      },
    });
  }
  // Reactive methods.
  hide(): void {
    this.isHidden.update((current) => !current);
  }
}
