package boying.dao.book;

import boying.BaseTest;
import boying.domain.book.StateCode;
import boying.domain.book.Video;
import boying.domain.book.VideoType;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
        videoDao.addVideo(video);

        long id = video.getId();
        Assert.assertTrue(id > 0);

        Video video2 = videoDao.getVideoById(id);
        Assert.assertTrue(video.getName().equals(video2.getName())
        && video.getPublisherName().equals(video2.getPublisherName())
        && video.getStateCode().equals(video2.getStateCode())
        && video.getType().equals(video2.getType()));
    }

}
