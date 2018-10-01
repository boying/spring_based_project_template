package boying.domain.enums;

/**
 * Created by boying on 2017/8/22.
 */
public enum BoolType implements EnumCode<Integer> {
    FALSE(0, "否"),
    TRUE(1, "是");
    int code;
    String desc;

    BoolType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
