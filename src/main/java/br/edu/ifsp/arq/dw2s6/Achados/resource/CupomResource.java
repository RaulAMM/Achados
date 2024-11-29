package br.edu.ifsp.arq.dw2s6.Achados.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.dw2s6.Achados.domain.model.Cupom;
import br.edu.ifsp.arq.dw2s6.Achados.repository.CupomRepository;


@RestController
@RequestMapping("/cupom")
public class CupomResource {

	@Autowired
	private CupomRepository cupomRepository;
	
	@GetMapping
	public List<Cupom> list(){
		return cupomRepository.findAll();
	}
	
}
