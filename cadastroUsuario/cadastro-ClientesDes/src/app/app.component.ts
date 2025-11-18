import { Component } from '@angular/core';
import { RouterOutlet,RouterLink,Router, NavigationEnd } from '@angular/router';
import { CommonModule } from '@angular/common';
import {MatToolbarModule} from '@angular/material/toolbar';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,RouterLink,MatToolbarModule,CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'cadastro-ClientesDes';
  isLoginRoute = false;
  isAdmin = false;

  constructor(private router: Router) {
    this.router.events
      .pipe(filter(event => event instanceof NavigationEnd))
      .subscribe((event: NavigationEnd) => {
        this.isLoginRoute = event.urlAfterRedirects.startsWith('/login');
        this.isAdmin = localStorage.getItem('perfil') === 'ADMIN';
      });
  }
}
