package es.udc.fic.tfg.horse;

import es.udc.fic.tfg.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface HorseRepository extends JpaRepository<Horse, Long> {

	Horse findOneByNickname(String nickname);

	Horse findOneByHorseId(Long horseid);

	@Query("select count(a) > 0 from Horse a where a.nickname = :nickname")
	boolean exists(@Param("nickname") String nickname);

	List<Horse> findAll();

	Page<Horse> findByOwner(Account owner, Pageable pageable);

	Page<Horse> findByRider(Account rider, Pageable pageable);


}