package cadastroUsuario.controller;

import java.util.List;

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

import cadastroUsuario.model.Email;
import cadastroUsuario.service.EmailService;

@RestController
@RequestMapping("/api/emails")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/cliente/{idCliente}")
	public ResponseEntity<List<Email>> listarPorCliente(@PathVariable Long idCliente){
		return ResponseEntity.ok().body(emailService.listaPorIdCli(idCliente));
	}
	
	@PostMapping("/cliente/{idCliente}")
	public ResponseEntity<Email> salvar(@PathVariable Long idCliente, @RequestBody Email email){
		return ResponseEntity.ok().body(emailService.salvar(idCliente, email));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Email> atualizar(@PathVariable Long id,@RequestBody Email email){
		return ResponseEntity.ok().body(emailService.atualizar(id,email));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		emailService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	

}
