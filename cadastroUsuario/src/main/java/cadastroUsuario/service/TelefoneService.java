package cadastroUsuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cadastroUsuario.model.Cliente;
import cadastroUsuario.model.Telefone;
import cadastroUsuario.repository.ClienteRepository;
import cadastroUsuario.repository.TelefoneRepository;

@Service
public class TelefoneService {
	@Autowired
	private TelefoneRepository telefoneRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Telefone> listarTelefoneIdCli(Long id){
		
		List<Telefone> telefones = telefoneRepository.findByclienteId(id);
		return telefones;
	}
	
	public Telefone salvar(Long idCli,Telefone telefone) {
		Cliente cliente = clienteRepository.findById(idCli).get();
		
		telefone.setCliente(cliente);
		
		return telefoneRepository.save(telefone);
	}
	public Telefone atualizar(Long idCli,Long idTele,Telefone telefone) {
		Cliente cliente = clienteRepository.findById(idCli).get();
		telefone.setId(idTele);
		telefone.setCliente(cliente);
		
		return telefoneRepository.save(telefone);
	}
	public void deletar(Long id) {
		telefoneRepository.deleteById(id);
	}
	

}
