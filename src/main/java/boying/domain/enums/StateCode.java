package boying.domain.enums;

public enum StateCode implements EnumCode<String> {
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
