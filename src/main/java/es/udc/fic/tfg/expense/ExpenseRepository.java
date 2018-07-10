package es.udc.fic.tfg.expense;

import es.udc.fic.tfg.account.Account;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

    Expense findOneByTitle(String title);

    @Query("select e from Expense e where e.consumer= :consumer")
    List<Expense> findByConsumer(@Param("consumer") Account consumer);
}
