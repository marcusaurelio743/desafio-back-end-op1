package cadastroUsuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cadastroUsuario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
