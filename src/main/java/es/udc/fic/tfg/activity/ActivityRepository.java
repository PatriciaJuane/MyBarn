package es.udc.fic.tfg.activity;

import es.udc.fic.tfg.account.Account;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    Activity findOneByActivityid(Long activityid);

    Page<Activity> findByActivityuser(Account consumer, Pageable pageable);

}
