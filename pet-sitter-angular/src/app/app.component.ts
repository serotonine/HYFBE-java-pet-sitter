import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LayoutModule } from '@angular/cdk/layout';
import { HeaderComponent } from './components/header/header.component';

@Component({
    selector: 'app-root',
    imports: [RouterOutlet, LayoutModule, HeaderComponent],
    templateUrl: './app.component.html'
})
export class AppComponent {
  title = 'pet-sitter-angular';
}
