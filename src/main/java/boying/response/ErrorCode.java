package boying.response;

/**
 * Created by boying on 2017/7/24.
 */
public enum ErrorCode {
    SUCCESS("0", "success"),
    FAILED("-1", "failed"),
    SYS_ERR("-2", "system error"),
    NOT_LOGIN("-3", "not login"),

    // book error code, 01xxx
    BOOK_CREATE_BOOK_FAILED("01001", "book created failed"),
    BOOK_NOT_FOUND("01002", "book not found"),

    // user error code
    USER_NOT_LOGIN("02001", "user not login")
    ;


    private String code;
    private String msg;

    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
