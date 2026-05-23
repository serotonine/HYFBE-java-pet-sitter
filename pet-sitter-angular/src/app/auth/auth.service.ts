import { Injectable, inject } from '@angular/core';
import { jwtDecode } from 'jwt-decode';
// User.
import { JwtPayload } from 'jwt-decode';
import { Role } from '@app/models/user.model';
import { UserService } from '@app/services/user.service';
// Router
import { Router } from '@angular/router';

interface TokenJwtPayload extends JwtPayload {
  userId: string;
  role: Role;
  email: string;
}

// Plain Service — you call it yourself.
@Injectable({
  providedIn: 'root',
})
export class AuthService {
  // User.
  private userService = inject(UserService);
  // Router.
  private router = inject(Router);
  // Tokens.
  private readonly TOKEN_KEY = 'auth_token';
  private readonly REFRESH_KEY = 'refresh_token';
  // , refreshToken: string
  saveTokens(token: string): void {
    localStorage.setItem(this.TOKEN_KEY, token);
    //localStorage.setItem(this.REFRESH_KEY, refreshToken);
  }

  getToken(): string | null {
    return localStorage.getItem(this.TOKEN_KEY);
  }

  getRefreshToken(): string | null {
    return localStorage.getItem(this.REFRESH_KEY);
  }

  clearTokens(): void {
    localStorage.removeItem(this.TOKEN_KEY);
    localStorage.removeItem(this.REFRESH_KEY);
  }
  decodeToken(token: string) {
    return jwtDecode(token);
  }
  // User.
  setUserFromToken(token: string): void {
    const payload = this.decodeToken(token) as TokenJwtPayload;
    this.userService.setUser({
      id: payload.userId,
      email: payload.sub,
      role: payload.role,
    });
  }
  // Logout.
  logout(): void {
    this.clearTokens();
    this.userService.clearUser();
    // Redirect to home page.
    this.router.navigate(['/planning']);
  }
  // !! => converts any value to a strict boolean.
  isLoggedIn(): boolean {
    return !!this.getToken();
  }
}
