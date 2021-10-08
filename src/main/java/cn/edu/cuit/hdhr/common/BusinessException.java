package cn.edu.cuit.hdhr.common;

/**
 * 当业务流程(因为用户未登录, 或权限不足等)需要提前中断时, 应抛出该类的异常对象, 并将告知前端的原因作为构造参数传入
 */
public class BusinessException extends RuntimeException {
    public BusinessException(String msg) {
        super(msg);
    }
}
