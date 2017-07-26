package boying.dao.book;

import boying.domain.book.Pic;
import org.apache.ibatis.annotations.Param;

/**
 * Created by boying on 2017/7/4.
 */
public interface PicDao {
    Pic getPicById(@Param("id") long id);

    void addPic(Pic pic);
}
