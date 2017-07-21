package org.walkerljl.toolkit.standard.exception;

/**
 * 应用RPC异常
 *
 * @version $Id: AppRpcException.java, v 0.1 2017年07月12日 下午4:10 junlin.ljl Exp $
 */
public class AppRpcException extends AppException {

    private static final long serialVersionUID = -6786549876849535944L;

    /**
     * 默认构造函数
     */
    public AppRpcException() {
        super();
    }

    /**
     * 构造函数
     *
     * @param message 异常消息
     */
    public AppRpcException(String message) {
        super(message);
    }


    /**
     * 构造函数
     *
     * @param e 异常对象
     */
    public AppRpcException(Throwable e) {
        super(e);
    }

    /**
     * 构造函数
     *
     * @param code 异常码
     */
    public AppRpcException(ErrorCode code) {
        super(code.getDescription());
        this.code = code;
    }

    /**
     * 构造函数
     *
     * @param code 异常码
     * @param message 异常消息
     */
    public AppRpcException(ErrorCode code, String message) {
        super(code, message);
    }

    /**
     * 构造函数
     *
     * @param message 异常消息
     * @param e 异常对象
     */
    public AppRpcException(String message, Throwable e) {
        super(message, e);
    }

    /**
     * 构造函数
     *
     * @param code 异常码
     * @param message 异常消息
     * @param e 异常对象
     */
    public AppRpcException(ErrorCode code, String message, Throwable e) {
        super(code, message, e);
    }
}