package cadastroUsuario.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cadastroUsuario.dto.ClienteDTO;
import cadastroUsuario.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> buscaTodos(){
		return ResponseEntity.ok().body(clienteService.buscaTodos());
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> salvar(@Valid @RequestBody ClienteDTO clienteDTO){
		return ResponseEntity.ok().body(clienteService.salvar(clienteDTO));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ClienteDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ClienteDTO clienteDTO){
		return ResponseEntity.ok().body(clienteService.atualizar(id, clienteDTO));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		clienteService.deltarCliente(id);
		
		return ResponseEntity.noContent().build();
	}

}
