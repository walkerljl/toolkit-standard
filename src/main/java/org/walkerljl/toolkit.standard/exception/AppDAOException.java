package org.walkerljl.toolkit.standard.exception;

/**
 * 数据访问异常
 *
 * @author lijunlin
 */
public class AppDAOException extends AppException {

    private static final long serialVersionUID = -6786549876849535944L;

    /**
     * 默认构造函数
     */
    public AppDAOException() {
        super();
    }

    /**
     * 构造函数
     *
     * @param message 异常消息
     */
    public AppDAOException(String message) {
        super(message);
    }

    /**
     * 构造函数
     *
     * @param code 异常码
     * @param message 异常消息
     */
    public AppDAOException(String code, String message) {
        super(code, message);
    }

    /**
     * 构造函数
     *
     * @param e 异常对象
     */
    public AppDAOException(Throwable e) {
        super(e);
    }

    /**
     * 构造函数
     *
     * @param message 异常消息
     * @param e 异常对象
     */
    public AppDAOException(String message, Throwable e) {
        super(message, e);
    }

    /**
     * 构造函数
     *
     * @param code 异常码
     * @param message 异常消息
     * @param e 异常对象
     */
    public AppDAOException(String code, String message, Throwable e) {
        super(code, message, e);
    }
}