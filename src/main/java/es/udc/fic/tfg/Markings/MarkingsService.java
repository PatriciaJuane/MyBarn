package es.udc.fic.tfg.Markings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MarkingsService {
	@Autowired
    MarkingsRepository markingsRepository;

	@Transactional
	public Markings save(Markings markings) {
		markingsRepository.save(markings);
		return markings;
	}


	@Transactional
	public List<Markings> findAll() {
		return markingsRepository.findAll();
	}
}
