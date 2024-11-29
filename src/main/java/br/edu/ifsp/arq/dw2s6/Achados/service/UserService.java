package br.edu.ifsp.arq.dw2s6.Achados.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.dw2s6.Achados.domain.model.Cupom;
import br.edu.ifsp.arq.dw2s6.Achados.domain.model.User;
import br.edu.ifsp.arq.dw2s6.Achados.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User update(int id, User user) {
		User userSaved = findUserById(id);
		BeanUtils.copyProperties(user, userSaved, "id");
		return userRepository.save(userSaved);
	}

	public void updateCupomProperty(int id, List<Cupom> cupom) {
		User userSaved = findUserById(id);
		userSaved.setCupoms(cupom);
		userRepository.save(userSaved);
	}
	
	public User findUserById(int id) {
		User userSaved = userRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return userSaved;
	}

}

