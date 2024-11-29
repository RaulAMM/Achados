package br.edu.ifsp.arq.dw2s6.Achados.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifsp.arq.dw2s6.Achados.domain.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findById(int Id_Usuario);
	
}
