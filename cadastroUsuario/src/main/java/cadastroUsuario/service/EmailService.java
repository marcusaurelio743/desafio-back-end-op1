package cadastroUsuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cadastroUsuario.model.Cliente;
import cadastroUsuario.model.Email;
import cadastroUsuario.repository.ClienteRepository;
import cadastroUsuario.repository.EmailRepository;

public class EmailService {
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EmailRepository emailRepository;
	
	public List<Email> listaPorIdCli(Long id) { 
		List<Email> emails = emailRepository.findByclienteId(id);
		return emails;
	}
	
	public Email salvar(Long idCli,Email email) {
		Cliente cliente = clienteRepository.findById(idCli).get();
		email.setCliente(cliente);
		return emailRepository.save(email);
	}
	public Email atualizar(Long idCli,Long idEmail,Email email) {
		Cliente cliente = clienteRepository.findById(idCli).get();
		email.setId(idEmail);
		email.setCliente(cliente);
		return emailRepository.save(email);
	}
	public void deletar(Long id) {
		emailRepository.deleteById(id);
	}
	
	

}
