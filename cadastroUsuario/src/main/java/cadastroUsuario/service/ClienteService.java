package cadastroUsuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cadastroUsuario.dto.ClienteDTO;
import cadastroUsuario.model.Cliente;
import cadastroUsuario.repository.ClienteRepository;
import cadastroUsuario.repository.EmailRepository;
import cadastroUsuario.repository.TelefoneRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private TelefoneRepository telefoneRepository;
	@Autowired 
	private EmailRepository emailRepository;
	
	public ClienteDTO salvar(ClienteDTO clienteDTO) {
		Cliente obj = new Cliente(clienteDTO);
		
		obj = clienteRepository.save(obj);
		
		return new ClienteDTO(obj);
	}
	
	public ClienteDTO atualizar(Long id, ClienteDTO dto) {
		dto.setId(id);
		Cliente obj = new Cliente(dto);
		obj = clienteRepository.save(obj);
		
		return new ClienteDTO(obj);
	}
	
	public void deltarCliente(Long id) {
		
		clienteRepository.deleteById(id);
	}

}
