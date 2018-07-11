package es.udc.fic.tfg.expense;

import es.udc.fic.tfg.account.Account;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

    Expense findOneByTitle(String title);

    Expense findOneByExpenseid(Long expenseid);

    Page<Expense> findByConsumer(Account consumer, Pageable pageable);
}
