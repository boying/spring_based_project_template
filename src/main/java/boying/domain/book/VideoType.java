package boying.domain.book;

import boying.domain.IntCode;

/**
 * Created by boying on 2017/8/22.
 */
public enum VideoType implements IntCode {
    ACTION(0, "动作片"),
    LOVE(1, "爱情片");
    int code;
    String desc;

    VideoType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public int getCode() {
        return code;
    }
}
