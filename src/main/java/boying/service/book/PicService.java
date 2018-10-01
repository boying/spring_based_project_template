package boying.service.book;

import boying.dao.book.PicDao;
import boying.domain.book.Pic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by boying on 2017/7/4.
 */
@Service
public class PicService {
    private static final Logger logger = LoggerFactory.getLogger(PicService.class);

    @Autowired
    private PicDao picDao;

    public Pic getPicById(long id) {
        logger.info("PicService.getPicById into, id is {}", id);
        return picDao.selectByPrimaryKey(id);
    }

    @Transactional("txManager")
    public void addPic(Pic pic) {
        picDao.insertSelective(pic);
    }

    public void log(){
        logger.error("this is error");
        logger.warn("this is warn");
        logger.info("this is info");
        logger.debug("this is debug");
    }
}
