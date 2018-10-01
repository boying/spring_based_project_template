package boying.domain.enums;

/**
 * Created by boying on 2017/8/22.
 */
public enum VideoType implements EnumCode<Integer> {
    ACTION(0, "动作片"),
    LOVE(1, "爱情片");
    int code;
    String desc;

    VideoType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
