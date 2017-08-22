package boying.domain.book;

import boying.domain.StringCode;

public enum StateCode implements StringCode{
    STATE_1("001", "state 1"),
    STATE_2("002", "state 2"),
    ;
    String code;
    String desc;

    StateCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return code;
    }
}
