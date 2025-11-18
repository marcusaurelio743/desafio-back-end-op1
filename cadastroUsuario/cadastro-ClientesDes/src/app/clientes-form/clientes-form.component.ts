import { Component, OnInit } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule, FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { HttpClient } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { NgxMaskDirective, NgxMaskPipe, provideNgxMask } from 'ngx-mask';

@Component({
  selector: 'app-clientes-form',
  imports: [
    MatCardModule,
    MatInputModule,
    FlexLayoutModule,
    FormsModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxMaskDirective,
    NgxMaskPipe,
    CommonModule
  ],
  providers: [
    provideNgxMask()
  ],
  templateUrl: './clientes-form.component.html',
  styleUrl: './clientes-form.component.css'
})
export class ClientesFormComponent implements OnInit {

  form!: FormGroup;
  backendErrors: any[] = [];

  constructor(
    private fb: FormBuilder,
    private http: HttpClient
  ) {}

  ngOnInit(): void {

    this.form = this.fb.group({
      id: [null],
      nome: ['', [
        Validators.required,
        Validators.pattern(/^[A-Za-zÀ-ÖØ-öø-ÿ\s]+$/)
      ]],
      cpf: ['', Validators.required],
      cep: [''],
      logradouro: [''],
      complemento: [''],
      bairro: [''],
      localidade: [''],
      uf: [''],
      estado: [''],

      // CORRIGIDO: arrays começam VAZIOS
      telefones: this.fb.array([]),
      emails: this.fb.array([])
    });

    // DEBUG opcional
    this.form.statusChanges.subscribe(status => {
      console.log("STATUS DO FORM:", status);
    });
  }

  /* -------------------------
      Métodos para Telefones
     ------------------------- */
  createTelefone(): FormGroup {
    return this.fb.group({
      telefone: ['', Validators.required],
      tipo: ['', Validators.required]
    });
  }

  get telefones(): FormArray {
    return this.form.get('telefones') as FormArray;
  }

  addTelefone() {
    this.telefones.push(this.createTelefone());
  }

  removeTelefone(i: number) {
    this.telefones.removeAt(i);
  }

  /* -------------------------
      Métodos para Emails
     ------------------------- */
  createEmail(): FormGroup {
    return this.fb.group({
      email: ['', [Validators.required, Validators.email]]
    });
  }

  get emails(): FormArray {
    return this.form.get('emails') as FormArray;
  }

  addEmail() {
    this.emails.push(this.createEmail());
  }

  removeEmail(i: number) {
    this.emails.removeAt(i);
  }

  /* -------------------------
      Busca CEP (ViaCEP)
     ------------------------- */
  buscarCep() {
    const cep = this.form.get('cep')?.value;

    if (cep && cep.length === 8) {
      this.http.get(`https://viacep.com.br/ws/${cep}/json/`)
        .subscribe((data: any) => {
          this.form.patchValue({
            logradouro: data.logradouro,
            complemento: data.complemento,
            bairro: data.bairro,
            localidade: data.localidade,
            uf: data.uf,
            estado: data.uf
          });
        });
    }
  }

  /* -------------------------
      Salvar Cliente
     ------------------------- */
  salvar() {
    this.backendErrors = [];

    this.http.post('http://localhost:8080/api/clientes', this.form.value)
      .subscribe({
        next: res => alert("Cliente salvo com sucesso!"),
        error: err => {
          this.backendErrors = err.error?.errors || [];
          console.error("ERRO DO BACKEND:", err);
        }
      });
  }

}
