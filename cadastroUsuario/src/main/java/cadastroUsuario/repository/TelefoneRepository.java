package cadastroUsuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cadastroUsuario.model.Telefone;
@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
	List<Telefone> findByclienteId(Long clienteId);
}
