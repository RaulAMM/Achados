package br.edu.ifsp.arq.dw2s6.Achados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.dw2s6.Achados.domain.model.Cupom;
import br.edu.ifsp.arq.dw2s6.Achados.domain.model.User;
import br.edu.ifsp.arq.dw2s6.Achados.repository.CupomRepository;
import br.edu.ifsp.arq.dw2s6.Achados.repository.UserRepository;
import br.edu.ifsp.arq.dw2s6.Achados.service.exception.NonExistentOrInactiveUserException;

@Service
public class CupomService {
	
	@Autowired
	private CupomRepository cupomRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Cupom save(Cupom cupom) {
		Optional<User> user = userRepository.findById(cupom.getUser().getIdUsuario());
		if(!user.isPresent() || user.get().getCupoms()== null){
			throw new NonExistentOrInactiveUserException();
		}
		return cupomRepository.save(cupom);
	}
	
	public Cupom update(int id, Cupom cupom) {
		Cupom cupomSaved = findCupomById(id);
		BeanUtils.copyProperties(cupom, cupomSaved, "id");
		return cupomRepository.save(cupomSaved);
	}
	
	public Cupom findCupomById(int id) {
		Cupom cupomSaved = cupomRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return cupomSaved;
	}
	
	public List<Cupom> findByUser(int id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
		return cupomRepository.findByUser(user.get());
		}
		return null;
		}
	
}
