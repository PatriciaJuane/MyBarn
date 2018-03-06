package es.udc.fic.tfg.Fur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FurService {
	@Autowired
	FurRepository furRepository;

	@Transactional
	public Fur save(Fur fur) {
		furRepository.save(fur);
		return fur;
	}


	@Transactional
	public List<Fur> findAll() {
		return furRepository.findAll();
	}
}
