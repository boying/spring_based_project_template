package boying.service.user;

import boying.domain.user.Phone;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by boying on 2017/7/4.
 */
//@Service
public class PhoneService {
    @Transactional("txManager1")
    public void createPhone(Phone phone){}
}
