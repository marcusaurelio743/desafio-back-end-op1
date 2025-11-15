package cadastroUsuario.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cadastroUsuario.dto.ClienteDTO;
import cadastroUsuario.model.Cliente;
import cadastroUsuario.model.Email;
import cadastroUsuario.model.Telefone;
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
	
	public List<ClienteDTO> buscaTodos(){
		List<Cliente> clientes = clienteRepository.findAll();
		List<ClienteDTO> clientesDtos = clientes.stream().map(x-> new ClienteDTO(x)).collect(Collectors.toList());
		
		return clientesDtos;
	}
	
	public ClienteDTO salvar(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente(clienteDTO);
		cliente.setCpf(RemoveMascara.removeMacara(clienteDTO.getCpf()));
		cliente.setCep(RemoveMascara.removeMacara(clienteDTO.getCep()));
		cliente = clienteRepository.save(cliente);
		
		List<Telefone> telefones = new ArrayList<>();
		
		for (Telefone fone : clienteDTO.getTelefones()) {
			Telefone telefone = new Telefone();
			telefone.setCliente(cliente);
			telefone.setTipo(fone.getTipo());
			telefone.setTelefone(RemoveMascara.removeMacara(fone.getTelefone()));
			telefones.add(telefone);
		}
		
		telefoneRepository.saveAll(telefones);
		
		List<Email> emails = new ArrayList<>();
		
		for (Email email : clienteDTO.getEmails()) {
			Email email2 = new Email();
			email2.setCliente(cliente);
			email2.setEmail(email.getEmail());
			emails.add(email2);
		}
		
		emailRepository.saveAll(emails);
		
		cliente.getEmails().addAll(emails);
		cliente.getTelefones().addAll(telefones);
		
		return new ClienteDTO(cliente);
	}
	
	
	public ClienteDTO atualizar(Long id, ClienteDTO dto) {
		
		Cliente cliente = clienteRepository.findById(id).get();
		cliente.setId(id);
		cliente.setBairro(dto.getBairro());
		cliente.setCep(RemoveMascara.removeMacara(dto.getCep()));
		cliente.setComplemento(dto.getComplemento());
		cliente.setCpf(RemoveMascara.removeMacara(dto.getCpf()));
		cliente.setEstado(dto.getEstado());
		cliente.setLocalidade(dto.getLocalidade());
		cliente.setLogradouro(dto.getLogradouro());
		cliente.setNome(dto.getNome());
		cliente.setUf(dto.getUf());
		
		cliente = clienteRepository.save(cliente);
		return new ClienteDTO(cliente);
	}
	
	public void deltarCliente(Long id) {
		
		clienteRepository.deleteById(id);
	}

}
