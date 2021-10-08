package cn.edu.cuit.hdhr.common;

import lombok.Data;

@Data
public class Result {
    private int status;
    private String msg;
    private Object data;

    public static Result succ(int status, String msg, Object data) {
        Result result = new Result();
        result.status = status;
        result.msg = msg;
        result.data = data;
        return result;
    }

    public static Result succ(String msg, Object data) {
        return Result.succ(200, msg, data);
    }

    public static Result succ(Object data) {
        return Result.succ(null, data);
    }

    public static Result fail(int status, String msg, Object data) {
        return succ(status, msg, data);
    }

    public static Result fail(String msg, Object data) {
        return Result.fail(400, msg, data);
    }

    public static Result fail(String msg) {
        return Result.fail(msg, null);
    }

    public static Result fail(int status, String msg) {
        return Result.fail(status, msg, null);
    }
}
