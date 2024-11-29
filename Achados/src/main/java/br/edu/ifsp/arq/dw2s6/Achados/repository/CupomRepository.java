package br.edu.ifsp.arq.dw2s6.Achados.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.arq.dw2s6.Achados.domain.model.Cupom;

public interface CupomRepository extends JpaRepository<Cupom, Integer>{
	Optional<Cupom> findviewby(int Id_Cupom);

}
