package cadastroUsuario.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cadastroUsuario.model.Cliente;
import cadastroUsuario.model.Email;
import cadastroUsuario.model.Telefone;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String cpf;
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private String estado;
	
	private List<Telefone> telefones = new ArrayList<>();
	
	private List<Email> emails = new ArrayList<>();
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<Email> getEmails() {
		return emails;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void AddEmails(Email email) {
		this.emails.add(email);
	}
	public void AddTelefones(Telefone telefone) {
		this.telefones.add(telefone);
	}

	

	@Override
	public String toString() {
		return "ClienteDTO [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", cep=" + cep + ", logradouro="
				+ logradouro + ", complemento=" + complemento + ", bairro=" + bairro + ", localidade=" + localidade
				+ ", uf=" + uf + ", estado=" + estado + "]";
	}

	public ClienteDTO(Long id, String nome, String cpf, String cep, String logradouro, String complemento,
			String bairro, String localidade, String uf, String estado,List<Telefone> telefones,List<Email> emails) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.estado = estado;
		this.emails = emails;
		this.telefones = telefones;
	}
	
	
	public ClienteDTO(Cliente obj) {
		
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.cep = obj.getCep();
		this.logradouro = obj.getLogradouro();
		this.complemento = obj.getComplemento();
		this.bairro = obj.getBairro();
		this.localidade = obj.getLocalidade();
		this.uf = obj.getUf();
		this.estado = obj.getEstado();
		this.emails = obj.getEmails();
		this.telefones = obj.getTelefones();
	}

	public ClienteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	

}
