package cadastroUsuario.service;

import org.springframework.beans.factory.annotation.Autowired;

import cadastroUsuario.repository.ClienteRepository;
import cadastroUsuario.repository.EmailRepository;
import cadastroUsuario.repository.TelefoneRepository;

public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private TelefoneRepository telefoneRepository;
	@Autowired 
	private EmailRepository emailRepository;
	
	

}
