import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { NgxMaskDirective, NgxMaskPipe, provideNgxMask } from 'ngx-mask';


@Component({
  selector: 'app-clientes-list',
  standalone: true,
  imports: [
    CommonModule,
    HttpClientModule,
    MatTableModule,
    MatButtonModule,
    FormsModule,
    NgxMaskDirective, NgxMaskPipe
  ],
  providers: [
    provideNgxMask()
  ],
  templateUrl: './clientes-list.component.html',
  styleUrl: './clientes-list.component.css'
})
export class ClientesListComponent implements OnInit {

  clientes: any[] = [];

  // usado nas edições
  selectedCliente: any = null;
  selectedTelefone: any = null;
  selectedEmail: any = null;

  apiClientes = "http://localhost:8080/api/clientes";
  apiTelefones = "http://localhost:8080/api/telefones";
  apiEmails = "http://localhost:8080/api/emails";

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.loadClientes();
  }

  /* -------------------------
      Buscar lista de clientes
     ------------------------- */
  loadClientes() {
    this.http.get<any[]>(this.apiClientes).subscribe({
      next: data => this.clientes = data,
      error: err => console.error(err)
    });
  }

  /* -------------------------
      Editar Telefone
     ------------------------- */
  abrirEdicaoTelefone(cliente: any, telefone: any) {
    this.selectedCliente = cliente;
    this.selectedTelefone = { ...telefone }; // clone do objeto original
  }

  salvarEdicaoTelefone() {
    this.http.put(
      `${this.apiTelefones}/${this.selectedTelefone.id}`,
      this.selectedTelefone
    ).subscribe({
      next: () => {
        alert("Telefone atualizado!");
        this.loadClientes();
        this.cancelarEdicao();
      },
      error: err => alert("Erro ao atualizar telefone!")
    });
  }

  removerTelefone(telefoneId: number) {
    this.http.delete(`${this.apiTelefones}/${telefoneId}`)
      .subscribe({
        next: () => {
          alert("Telefone removido!");
          this.loadClientes();
        }
      });
  }

  /* -------------------------
      Editar Email
     ------------------------- */
  abrirEdicaoEmail(cliente: any, email: any) {
    this.selectedCliente = cliente;
    this.selectedEmail = { ...email };
  }

  salvarEdicaoEmail() {
    this.http.put(
      `${this.apiEmails}/${this.selectedEmail.id}`,
      this.selectedEmail
    ).subscribe({
      next: () => {
        alert("Email atualizado!");
        this.loadClientes();
        this.cancelarEdicao();
      }
    });
  }

  removerEmail(emailId: number) {
    this.http.delete(`${this.apiEmails}/${emailId}`)
      .subscribe({
        next: () => {
          alert("Email removido!");
          this.loadClientes();
        }
      });
  }

  cancelarEdicao() {
    this.selectedCliente = null;
    this.selectedTelefone = null;
    this.selectedEmail = null;
  }
}
