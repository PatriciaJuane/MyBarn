package es.udc.fic.tfg.account;

import es.udc.fic.tfg.horse.Horse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findOneByEmail(String email);

	@Query("select count(a) > 0 from Account a where a.email = :email")
	boolean exists(@Param("email") String email);

	/*@Query("select horse.id, horse.name FROM horse inner join accounts_horses " +
			"on accounts_horses.horse_id=horse.id " +
			"where accounts_horses.horse_id=$horse_id")
	List<Horse> findHorsesByAccount(@Param("horse_id") Horse horse);*/
}