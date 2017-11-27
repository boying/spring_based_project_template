package boying.common.mybatis;

import boying.domain.book.VideoType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(VideoType.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class VideoTypeHandler extends EnumTypeHandler {
    public VideoTypeHandler() {
        super(VideoType.class);
    }
}
