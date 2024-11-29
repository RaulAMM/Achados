package br.edu.ifsp.arq.dw2s6.Achados.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.dw2s6.Achados.domain.model.Instituicao;
import br.edu.ifsp.arq.dw2s6.Achados.repository.InstituicaoRepository;


@RestController
@RequestMapping
public class InstituicaoResource {

	@Autowired
	private InstituicaoRepository instituicaoRepository;
	
	@GetMapping
	public List<Instituicao> list(){
		return instituicaoRepository.findAll();
	}
	
}
