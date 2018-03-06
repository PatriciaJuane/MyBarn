package es.udc.fic.tfg.Gender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenderService {
	@Autowired
	GenderRepository genderRepository;

	@Transactional
	public Gender save(Gender gender) {
		genderRepository.save(gender);
		return gender;
	}


	@Transactional
	public List<Gender> findAll() {
		return genderRepository.findAll();
	}
}
