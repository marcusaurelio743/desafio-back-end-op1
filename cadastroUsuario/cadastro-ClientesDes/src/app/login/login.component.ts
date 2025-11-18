import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, Validators, FormGroup } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form!: FormGroup;
  backendError: string = '';

  constructor(
    private fb: FormBuilder,
    private auth: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      usuario: ['', Validators.required],   // 👈 CORRIGIDO
      senha: ['', Validators.required]
    });
  }

  entrar() {
    this.backendError = '';

    if (this.form.invalid) {
      this.backendError = "Preencha todos os campos!";
      return;
    }

    const { usuario, senha } = this.form.value;

    this.auth.login(usuario, senha).subscribe({
      next: (res) => {
    this.auth.saveSession(res.token, res.perfil);
      this.router.navigate(['/lista']);
    },
      error: err => {
        this.backendError =
          err.error?.message || "Usuário ou senha inválidos.";
      }
    });
  }
}
