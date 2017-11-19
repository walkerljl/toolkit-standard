package org.walkerljl.toolkit.standard.exception.machine;

import org.walkerljl.toolkit.standard.exception.AppException;
import org.walkerljl.toolkit.standard.exception.code.ErrorCode;

/**
 * Machine异常
 *
 * @author lijunlin
 */
public class MachineException extends AppException {

    private static final long serialVersionUID = -6786549876849535944L;

    /**
     * 默认构造函数
     */
    public MachineException() {
        super();
    }

    /**
     * 构造函数
     *
     * @param message 消息
     */
    public MachineException(String message) {
        super(message);
    }

    /**
     * 构造函数
     *
     * @param code 异常码
     * @param message 消息
     */
    public MachineException(ErrorCode code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 构造函数
     *
     * @param e 异常对象
     */
    public MachineException(Throwable e) {
        super(e);
    }

    /**
     * 构造函数
     *
     * @param message 异常消息
     * @param e 异常对象
     */
    public MachineException(String message, Throwable e) {
        super(message, e);
    }

    /**
     * 构造函数
     *
     * @param code 异常码
     * @param message 异常消息
     * @param e 异常对象
     */
    public MachineException(ErrorCode code, String message, Throwable e) {
        super(message, e);
        this.code = code;
    }
}