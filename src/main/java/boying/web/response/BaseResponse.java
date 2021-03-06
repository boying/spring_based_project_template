package boying.web.response;

import lombok.Data;

/**
 * Created by boying on 2017/7/21.
 */
@Data
public class BaseResponse<T> {
    private String code;
    private String msg;
    private T data;

    public BaseResponse(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse(ErrorCode code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.data = null;
    }

    public BaseResponse(ErrorCode code, T data) {
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.data = data;
    }

    public static <T> BaseResponse<T> buildResponse(String code, String msg, T data) {
        return new BaseResponse<T>(code, msg, data);
    }

    public static <T> BaseResponse<T> buildResponse(ErrorCode code, T data) {
        return new BaseResponse<T>(code, data);
    }

    public static <T> BaseResponse<T> buildResponse(ErrorCode code) {
        return new BaseResponse<T>(code);
    }

    public static <T> BaseResponse<T> success() {
        return new BaseResponse<T>(ErrorCode.SUCCESS);
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<T>(ErrorCode.SUCCESS, data);
    }

    public static <T> BaseResponse<T> sysErr() {
        return new BaseResponse<T>(ErrorCode.SYS_ERR, null);
    }
}
