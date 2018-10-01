package boying.dao.book;

import boying.BaseUnitilsTest;
import boying.dao.book.mapper.VideoMapper;
import boying.domain.book.Video;
import boying.domain.enums.BoolType;
import boying.domain.enums.StateCode;
import boying.domain.enums.VideoType;
import org.junit.Assert;
import org.junit.Test;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.spring.annotation.SpringBeanByName;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Transactional(value = TransactionMode.ROLLBACK, transactionManagerName = "txManager")
public class VideoMapperTest extends BaseUnitilsTest {
    @SpringBeanByName()
    private VideoMapper videoMapper;

    @Test
    public void addAndGetTest() {

        Video video = new Video();
        video.setName("name_x");
        video.setPublisherName("publisher_name_x");
        video.setStateCode(StateCode.STATE_1);
        video.setType(VideoType.LOVE);
        video.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        video.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        video.setIsDelete(BoolType.TRUE);
        videoMapper.insert(video);

        Long id = video.getId();
        Assert.assertTrue(id > 0);

        Video video2 = videoMapper.selectByPrimaryKey(id);
        Assert.assertNotNull(video2);
    }
}

