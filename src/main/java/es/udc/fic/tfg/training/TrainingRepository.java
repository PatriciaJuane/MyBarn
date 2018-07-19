package es.udc.fic.tfg.training;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.udc.fic.tfg.account.Account;
import es.udc.fic.tfg.expense.Expense;
import es.udc.fic.tfg.horse.Horse;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long>{

    Training findOneByTrainingid(Long trainingid);

    Page<Training> findByTraininguser(Account account, Pageable pageable);

    List<Training> findByTraininguser(Account account);

    Page <Training> findByTraininguserAndTraininghorse(Account account, Horse horse, Pageable pageable);

    Training findByTrainingexpense(Expense expense);
}
