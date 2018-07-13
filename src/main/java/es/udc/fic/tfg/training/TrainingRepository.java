package es.udc.fic.tfg.training;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.horse.Horse;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long>{

    Training findOneByTrainingid(Long trainingid);

    Page<Training> findByTraininguser(Account account, Pageable pageable);

    Page <Training> findByTraininguserAndTraininghorse(Account account, Horse horse, Pageable pageable);

}
