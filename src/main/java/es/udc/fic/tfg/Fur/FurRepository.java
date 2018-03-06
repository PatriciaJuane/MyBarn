package es.udc.fic.tfg.Fur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurRepository extends JpaRepository<Fur, Long> {

}
