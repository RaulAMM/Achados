package br.edu.ifsp.arq.dw2s6.Achados.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.dw2s6.Achados.domain.model.Instituicao;
import br.edu.ifsp.arq.dw2s6.Achados.repository.InstituicaoRepository;



@RestController
@RequestMapping("/instituicao")
public class InstituicaoResource {

	@Autowired
	private InstituicaoRepository instituicaoRepository;	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_SEARCH_ACTIVITY') and hasAuthority('SCOPE_read')")
	public List<Instituicao> list(){
		return instituicaoRepository.findAll();
	}
	
	@GetMapping("/{cnpj}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_ACTIVITY') and hasAuthority('SCOPE_read')")
	public ResponseEntity<Instituicao> findById(@PathVariable String cnpj) {
		Optional<Instituicao> instituicao = instituicaoRepository.findByCnpj(cnpj);
		if(!instituicao.isEmpty()) {
			return ResponseEntity.ok(instituicao.get());
		}
		return ResponseEntity.notFound().build();
	}
}
