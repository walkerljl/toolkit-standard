package org.walkerljl.toolkit.standard.exception.resouce;

import org.walkerljl.toolkit.standard.exception.code.ErrorCode;

/**
 * 不能初始化资源异常
 *
 * @author lijunlin
 */
public class CannotInitResourceException extends ResourceException {

    private static final long serialVersionUID = -6786549876849535944L;

    /**
     * 默认构造函数
     */
    public CannotInitResourceException() {
        super();
    }

    /**
     * 构造函数
     *
     * @param message 消息
     */
    public CannotInitResourceException(String message) {
        super(message);
    }

    /**
     * 构造函数
     *
     * @param code 异常码
     * @param message 消息
     */
    public CannotInitResourceException(ErrorCode code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 构造函数
     *
     * @param e 异常对象
     */
    public CannotInitResourceException(Throwable e) {
        super(e);
    }

    /**
     * 构造函数
     *
     * @param message 异常消息
     * @param e 异常对象
     */
    public CannotInitResourceException(String message, Throwable e) {
        super(message, e);
    }

    /**
     * 构造函数
     *
     * @param code 异常码
     * @param message 异常消息
     * @param e 异常对象
     */
    public CannotInitResourceException(ErrorCode code, String message, Throwable e) {
        super(message, e);
        this.code = code;
    }
}