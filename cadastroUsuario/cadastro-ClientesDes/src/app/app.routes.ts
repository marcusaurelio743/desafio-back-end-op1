import { Routes } from '@angular/router';
import { ClientesListComponent } from './clientes-list/clientes-list.component';
import { ClientesFormComponent } from './clientes-form/clientes-form.component';
import { LoginComponent } from './login/login.component';

export const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  {path:'login',component:LoginComponent},
  {path:'lista',component: ClientesListComponent},
  {path:'cadastro', component: ClientesFormComponent},
  { path: '**', redirectTo: '/login' },
];
