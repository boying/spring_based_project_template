package boying.common.mybatis;

import boying.domain.book.StateCode;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(StateCode.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class StateCodeHandler extends EnumTypeHandler {
    public StateCodeHandler() {
        super(StateCode.class);
    }
}
