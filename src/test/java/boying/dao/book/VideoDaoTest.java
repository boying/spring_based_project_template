package boying.dao.book;

import boying.BaseTest;
import boying.domain.book.StateCode;
import boying.domain.book.Video;
import boying.domain.book.VideoType;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Transactional("txManager")
public class VideoDaoTest extends BaseTest {
    @Autowired
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
        videoDao.addVideo(video);

        long id = video.getId();
        Assert.assertTrue(id > 0);

        Video video2 = videoDao.getVideoById(id);
        Assert.assertTrue(video.equals(video2));
    }

}
