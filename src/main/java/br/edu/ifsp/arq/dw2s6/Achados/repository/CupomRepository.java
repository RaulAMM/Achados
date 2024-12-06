package br.edu.ifsp.arq.dw2s6.Achados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.arq.dw2s6.Achados.domain.model.Cupom;
import br.edu.ifsp.arq.dw2s6.Achados.domain.model.User;

public interface CupomRepository extends JpaRepository<Cupom, Long>{
	List<Cupom> findByUser(User user);
}
