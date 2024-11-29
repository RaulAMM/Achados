package br.edu.ifsp.arq.dw2s6.Achados.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.arq.dw2s6.Achados.domain.model.Instituicao;

public interface InstituicaoRepository extends JpaRepository<Instituicao, String>{
	
	Optional<Instituicao> findByCnpj(String cnpj);
}
