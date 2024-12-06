package br.edu.ifsp.arq.dw2s6.Achados.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.dw2s6.Achados.domain.model.Cupom;
import br.edu.ifsp.arq.dw2s6.Achados.repository.CupomRepository;
import br.edu.ifsp.arq.dw2s6.Achados.service.CupomService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/cupom")
public class CupomResource {

	@Autowired
	private CupomRepository cupomRepository;
	
	@Autowired
	private CupomService cupomService;	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_SEARCH_ACTIVITY') and hasAuthority('SCOPE_read')")
	public List<Cupom> list(){
		return cupomRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_ACTIVITY') and hasAuthority('SCOPE_read')")
	public ResponseEntity<Cupom> findById(@PathVariable Long id) {
		Optional<Cupom> cupom = cupomRepository.findById(id);
		if(cupom.isPresent()) {
			return ResponseEntity.ok(cupom.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/user/{email}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_ACTIVITY') and hasAuthority('SCOPE_read')")
	public ResponseEntity<List<Cupom>> finfByUser(@PathVariable String email){
		List<Cupom> cupom = cupomService.findByUser(email);
		if(!cupom.isEmpty()) {
			return ResponseEntity.ok(cupom);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ROLE_REGISTER_ACTIVITY') and hasAuthority('SCOPE_write')")
	public Cupom create(@Valid @RequestBody Cupom cupom) {
		return cupomService.save(cupom);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVE_ACTIVITY') and hasAuthority('SCOPE_write')")
	public void delete(@PathVariable Long id) {
		cupomRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_REGISTER_ACTIVITY') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Cupom> update(@PathVariable Long id, @Valid @RequestBody Cupom cupom) {
		Cupom cupomSaved = cupomService.update(id, cupom);
		return ResponseEntity.ok(cupomSaved);
	}
	
}
