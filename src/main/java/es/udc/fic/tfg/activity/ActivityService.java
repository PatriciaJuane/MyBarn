package es.udc.fic.tfg.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Transactional
    public Activity save(Activity activity){
        activityRepository.save(activity);
        return activity;
    }

    public Activity findOneById(Long activityid) {
        Activity activity = activityRepository.findOneByActivityid(activityid);
        return activity;
    }
}
