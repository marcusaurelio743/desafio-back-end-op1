package cadastroUsuario.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cadastroUsuario.dto.ClienteDTO;
import cadastroUsuario.model.Cliente;
import cadastroUsuario.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public List<ClienteDTO> buscaTodos(){
		List<Cliente> clientes = clienteRepository.findAll();
		List<ClienteDTO> clientesDtos = clientes.stream().map(x-> new ClienteDTO(x)).collect(Collectors.toList());
		
		return clientesDtos;
	}
	
	public ClienteDTO salvar(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente(clienteDTO);		
		cliente = clienteRepository.save(cliente);
		
		return new ClienteDTO(cliente);
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
