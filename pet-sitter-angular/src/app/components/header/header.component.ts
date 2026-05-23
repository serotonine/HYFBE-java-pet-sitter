import { Component, inject } from '@angular/core';
import { RouterModule } from '@angular/router';
import { UserService } from '@app/services/user.service';
import { AuthService } from '@app/auth/auth.service';
// User menu
import {MatMenuModule} from '@angular/material/menu';
import {MatButtonModule} from '@angular/material/button';

@Component({
  selector: 'app-header',
  imports: [RouterModule, MatButtonModule,MatMenuModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss',
})
export class HeaderComponent {
  private userService: UserService = inject(UserService);
  private auth:AuthService = inject(AuthService);
  protected user = this.userService.getUser;
  protected initial = this.userService.getInitial;
  protected id = this.userService.getId;
  // Event handler.
  logout():void{
    this.auth.logout();
  }
}
