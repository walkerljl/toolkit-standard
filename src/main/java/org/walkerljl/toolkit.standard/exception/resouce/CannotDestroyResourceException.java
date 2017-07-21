package org.walkerljl.toolkit.standard.exception.resouce;

import org.walkerljl.toolkit.standard.exception.ErrorCode;

/**
 * 不能销毁资源异常
 *
 * @author lijunlin
 */
public class CannotDestroyResourceException extends ResourceException {

    private static final long serialVersionUID = -6786549876849535944L;

    /**
     * 默认构造函数
     */
    public CannotDestroyResourceException() {
        super();
    }

    /**
     * 构造函数
     *
     * @param message 消息
     */
    public CannotDestroyResourceException(String message) {
        super(message);
    }

    /**
     * 构造函数
     *
     * @param code 异常码
     * @param message 消息
     */
    public CannotDestroyResourceException(ErrorCode code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 构造函数
     *
     * @param e 异常对象
     */
    public CannotDestroyResourceException(Throwable e) {
        super(e);
    }

    /**
     * 构造函数
     *
     * @param message 异常消息
     * @param e 异常对象
     */
    public CannotDestroyResourceException(String message, Throwable e) {
        super(message, e);
    }

    /**
     * 构造函数
     *
     * @param code 异常码
     * @param message 异常消息
     * @param e 异常对象
     */
    public CannotDestroyResourceException(ErrorCode code, String message, Throwable e) {
        super(message, e);
        this.code = code;
    }
}