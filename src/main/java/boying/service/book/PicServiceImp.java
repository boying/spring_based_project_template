package boying.service.book;

import boying.dao.book.PicDao;
import boying.domain.book.Pic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by boying on 17-11-23.
 */
@Service
public class PicServiceImp implements IPicService{
    @Autowired
    private PicDao picDao;

    @Transactional("txManager")
    public void addPicThrowException(Pic pic) {
        picDao.addPic(pic);
        throw new RuntimeException();
    }

    public void addPicSelfInvocation(Pic pic){
        this.addPicThrowException(pic);
    }

    public Pic getPic(long id){
        return picDao.getPicById(id);
    }
}
