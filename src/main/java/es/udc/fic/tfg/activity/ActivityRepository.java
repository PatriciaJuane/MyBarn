package es.udc.fic.tfg.activity;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    Activity findOneByActivityid(Long activityid);

}
