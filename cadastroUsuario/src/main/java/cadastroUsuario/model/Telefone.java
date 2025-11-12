package cadastroUsuario.model;

import java.io.Serializable;
import java.util.Objects;

public class Telefone implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String tipo;
	private String telefone;
	
	private Cliente cliente;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Telefone(Long id, String tipo, String telefone, Cliente cliente) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.telefone = telefone;
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Telefone() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Telefone [id=" + id + ", tipo=" + tipo + ", telefone=" + telefone + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
