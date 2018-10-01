package boying.dao.book;

import boying.BaseUnitilsTest;
import boying.domain.enums.StateCode;
import boying.domain.book.Video;
import boying.domain.enums.VideoType;
import org.junit.Assert;
import org.junit.Test;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBeanByType;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Transactional(value = TransactionMode.ROLLBACK, transactionManagerName = "txManager")
public class VideoDaoTest extends BaseUnitilsTest {
    @SpringBeanByType
    private VideoDao videoDao;

    @Test
    public void addAndGetTest() {
        Video video = new Video();
        video.setName("name_x");
        video.setPublisherName("publisher_name_x");
        video.setStateCode(StateCode.STATE_2);
        video.setType(VideoType.LOVE);
        video.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        video.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        videoDao.insertSelective(video);

        long id = video.getId();
        Assert.assertTrue(id > 0);

        Video video2 = videoDao.selectByPrimaryKey(id);
        Assert.assertNotNull(video2);
    }

    @Test
    @DataSet("/dataset/VideoDaoTest/getTest.xml")
    public void getTest() {
        Video videox = videoDao.selectByPrimaryKey(1L);
        Assert.assertNotNull(videox);

        Video video = new Video();
        video.setName("name_x");
        video.setPublisherName("publisher_name_x");
        video.setStateCode(StateCode.STATE_2);
        video.setType(VideoType.LOVE);
        video.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        video.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        videoDao.insertSelective(video);
        long id = video.getId();
        Assert.assertTrue(id > 0);

        Video video2 = videoDao.selectByPrimaryKey(id);
        Assert.assertNotNull(video2);
    }

}
