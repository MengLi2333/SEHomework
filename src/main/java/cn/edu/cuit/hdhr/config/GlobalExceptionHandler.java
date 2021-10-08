package cn.edu.cuit.hdhr.config;

import cn.edu.cuit.hdhr.common.BusinessException;
import cn.edu.cuit.hdhr.common.Result;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ShiroException.class)
    public Result handle401(Exception e) {
        return Result.fail(HttpStatus.UNAUTHORIZED.value(), "登录或权限异常");
    }

    @ExceptionHandler(BusinessException.class)
    public Result handle400(BusinessException e) {
        return Result.fail(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result handle400(MissingServletRequestParameterException e) {
        return Result.fail(HttpStatus.BAD_REQUEST.value(), "请求参数异常");
    }

//    @ExceptionHandler(Exception.class)
//    public Result handleUnexpected(Exception e) { // status: 400
//        return Result.fail(HttpStatus.BAD_REQUEST.value(), "UnexpectedException");
//    }
}
