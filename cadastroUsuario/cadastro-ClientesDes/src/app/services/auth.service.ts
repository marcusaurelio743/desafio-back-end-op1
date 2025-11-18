import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {



  constructor(private http: HttpClient) {}



  saveToken(token: string) {
    localStorage.setItem('token', token);
  }
  login(usuario: string, senha: string) {
  return this.http.post<any>('http://localhost:8080/api/auth/login', {
    usuario,
    senha
  });
}

saveSession(token: string, perfil: string) {
  localStorage.setItem('token', token);
  localStorage.setItem('perfil', perfil);
}

getPerfil() {
  return localStorage.getItem('perfil');
}
}
