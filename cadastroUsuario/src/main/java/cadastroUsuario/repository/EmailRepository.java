package cadastroUsuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cadastroUsuario.model.Email;
@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
	
	List<Email> findByclienteId(Long clienteId);

}
