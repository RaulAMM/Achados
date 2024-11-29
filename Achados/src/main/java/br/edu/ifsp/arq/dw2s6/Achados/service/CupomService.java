package br.edu.ifsp.arq.dw2s6.Achados.service;

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
	private CupomRepository activityRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Cupom save(Cupom cupom) {
		Optional<User> user = userRepository.findById(cupom.getUser().getId());
		if(!user.isPresent() || user.get().getCupoms()== null){
			throw new NonExistentOrInactiveUserException();
		}
		return activityRepository.save(cupom);
	}
	
	public Cupom update(Long id, Cupom cupom) {
		Cupom cupomSaved = findActivityById(id);
		BeanUtils.copyProperties(cupom, activitySaved, "id");
		return activityRepository.save(activitySaved);
	}
	
	public Cupom findCupomById(int id) {
		Cupom cupomSaved = CupomRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return cupomSaved;
	}

}
