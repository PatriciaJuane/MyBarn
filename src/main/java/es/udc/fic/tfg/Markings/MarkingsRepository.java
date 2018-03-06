package es.udc.fic.tfg.Markings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkingsRepository extends JpaRepository<Markings, Long> {

}
