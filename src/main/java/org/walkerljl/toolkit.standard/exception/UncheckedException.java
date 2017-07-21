package org.walkerljl.toolkit.standard.exception;

/**
 * 非检查型异常
 *
 * @version $Id: AppServiceException.java, v 0.1 2017年07月12日 下午4:10 junlin.ljl Exp $
 */
public class UncheckedException extends RuntimeException {

    private static final long serialVersionUID = -6786549876849535944L;

    /**
     * 默认构造函数
     */
    public UncheckedException() {
        super();
    }

    /**
     * 构造函数
     *
     * @param message
     */
    public UncheckedException(String message) {
        super(message);
    }

    /**
     * 构造函数
     *
     * @param e
     */
    public UncheckedException(Throwable e) {
        super(e);
    }

    /**
     * 构造函数
     *
     * @param message
     * @param e
     */
    public UncheckedException(String message, Throwable e) {
        super(message, e);
    }
}