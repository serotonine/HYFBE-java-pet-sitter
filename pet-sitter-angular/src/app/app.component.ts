import { Component, inject } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LayoutModule } from '@angular/cdk/layout';
// Service.
import { AuthService } from './auth/auth.service';
// Component.
import { HeaderComponent } from './components/header/header.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, LayoutModule, HeaderComponent],
  templateUrl: './app.component.html',
})
export class AppComponent {
  title = 'pet-sitter-angular';
  private auth: AuthService = inject(AuthService);

  ngOnInit() {
    // Authentication.
    const token: string | null = this.auth.getToken();
    if (token) {
      this.auth.setUserFromToken(token);
    }
  }
}
