package org.walkerljl.toolkit.standard.exception.machine;

import org.walkerljl.toolkit.standard.exception.ErrorCode;

/**
 * 不能停止异常
 *
 * @author lijunlin
 */
public class CannotStopMachineException extends MachineException {

    private static final long serialVersionUID = -6786549876849535944L;

    /**
     * 默认构造函数
     */
    public CannotStopMachineException() {
        super();
    }

    /**
     * 构造函数
     *
     * @param message 消息
     */
    public CannotStopMachineException(String message) {
        super(message);
    }

    /**
     * 构造函数
     *
     * @param code 异常码
     * @param message 消息
     */
    public CannotStopMachineException(ErrorCode code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 构造函数
     *
     * @param e 异常对象
     */
    public CannotStopMachineException(Throwable e) {
        super(e);
    }

    /**
     * 构造函数
     *
     * @param message 异常消息
     * @param e 异常对象
     */
    public CannotStopMachineException(String message, Throwable e) {
        super(message, e);
    }

    /**
     * 构造函数
     *
     * @param code 异常码
     * @param message 异常消息
     * @param e 异常对象
     */
    public CannotStopMachineException(ErrorCode code, String message, Throwable e) {
        super(message, e);
        this.code = code;
    }
}