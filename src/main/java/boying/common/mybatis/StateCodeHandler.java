package boying.common.mybatis;

import boying.domain.book.StateCode;
import boying.domain.book.VideoType;

public class StateCodeHandler extends EnumTypeHandler {
    public StateCodeHandler() {
        super(StateCode.class);
    }
}
