package cadastroUsuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cadastroUsuario.model.Telefone;
import cadastroUsuario.service.TelefoneService;

@RestController
@RequestMapping("/api/telefones")
@CrossOrigin
public class TelefoneController {
	@Autowired
	private TelefoneService telefoneService;
	
	@GetMapping("/cliente/{clienteId}")
	public ResponseEntity<List<Telefone>> listaPorCliente(@PathVariable Long clienteId){
		return ResponseEntity.ok().body(telefoneService.listarTelefoneIdCli(clienteId));
	}
	
	@PostMapping("/cliente/{clienteId}")
	public ResponseEntity<Telefone> salvar(@PathVariable Long clienteId, @RequestBody Telefone telefone){
		return ResponseEntity.ok().body(telefoneService.salvar(clienteId, telefone));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Telefone> atualizar(@PathVariable Long id, @RequestBody Telefone telefone){
		return ResponseEntity.ok().body(telefoneService.atualizar(id, telefone));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		telefoneService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	

}
