package org.walkerljl.toolkit.standard.exception;

/**
 * 应用业务逻辑异常
 *
 * @version $Id: AppServiceException.java, v 0.1 2017年07月12日 下午4:10 junlin.ljl Exp $
 */
public class AppServiceException extends AppException {

    private static final long serialVersionUID = -6786549876849535944L;

    /**
     * 默认构造函数
     */
    public AppServiceException() {
        super();
    }

    /**
     * 构造函数
     *
     * @param message 异常消息
     */
    public AppServiceException(String message) {
        super(message);
    }

    /**
     * 构造函数
     *
     * @param e 异常对象
     */
    public AppServiceException(Throwable e) {
        super(e);
    }

    /**
     * 构造函数
     *
     * @param code 异常码
     */
    public AppServiceException(ErrorCode code) {
        super(code.getDescription());
        this.code = code;
    }

    /**
     * 构造函数
     *
     * @param code 异常码
     * @param message 异常消息
     */
    public AppServiceException(ErrorCode code, String message) {
        super(code, message);
    }

    /**
     * 构造函数
     *
     * @param message 异常消息
     * @param e 异常对象
     */
    public AppServiceException(String message, Throwable e) {
        super(message, e);
    }

    /**
     * 构造函数
     *
     * @param code 异常码
     * @param message 异常消息
     * @param e 异常对象
     */
    public AppServiceException(ErrorCode code, String message, Throwable e) {
        super(code, message, e);
    }
}