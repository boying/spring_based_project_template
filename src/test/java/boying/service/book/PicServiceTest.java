package boying.service.book;

import boying.BaseTest;
import boying.domain.book.Pic;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by boying on 2017/7/6.
 */
@Transactional("txManager")
public class PicServiceTest extends BaseTest{
    @Autowired
    private PicService picService;

    @Test
    public void addAndGetTest(){
        Pic pic = new Pic();
        pic.setName("picName");
        picService.addPic(pic);
        Assert.assertTrue(pic.getId() > 0);

        Pic getPic = picService.getPicById(pic.getId());
        Assert.assertNotNull(getPic);
        Assert.assertTrue(pic.getName().equals(getPic.getName()));
    }

    @Test
    public void logTest(){
        picService.log();
    }
}
