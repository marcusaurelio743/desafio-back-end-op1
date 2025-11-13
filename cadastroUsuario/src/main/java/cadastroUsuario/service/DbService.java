package cadastroUsuario.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cadastroUsuario.model.Usuario;
import cadastroUsuario.repository.UsuarioRepository;

@Service
public class DbService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void instanciaDB() {
		Usuario usuario1 = new Usuario();
		usuario1.setPerfil("padrao");
		usuario1.setUsuario("usuario");
		usuario1.setSenha("123qwe123");
		
		Usuario usuario2 = new Usuario();
		usuario2.setPerfil("admin");
		usuario2.setUsuario("admin");
		usuario2.setSenha("123qwe!@#");
		
		usuarioRepository.saveAll(Arrays.asList(usuario1,usuario2));
		
	}

}
