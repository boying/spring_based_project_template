package boying.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by boying on 2017/7/20.
 */
@Component
public class HelloShedule {
    private static Logger logger = LoggerFactory.getLogger(HelloShedule.class);

    @Scheduled(cron = "0/2 * *  * * ?")
    public void hello() {
        if (isOpened()) {
            logger.info("schedule hello!!!");
        }
    }

    private boolean isOpened() {
        return false;
    }
}
