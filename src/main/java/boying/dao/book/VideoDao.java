package boying.dao.book;

import boying.domain.book.Video;
import org.apache.ibatis.annotations.Param;

public interface VideoDao {
    Video getVideoById(@Param("id") long id);

    void addVideo(Video video);
}
