package org.walkerljl.toolkit.standard.exception.machine;

import org.walkerljl.toolkit.standard.exception.AppException;
import org.walkerljl.toolkit.standard.exception.code.ErrorCode;

/**
 * Exception of machine
 *
 * @author xingxun
 */
public class MachineException extends AppException {

    private static final long serialVersionUID = -6786549876849535944L;

    /**
     * Constructor
     */
    public MachineException() {
        super();
    }

    /**
     * Constructor
     *
     * @param message Message
     */
    public MachineException(String message) {
        super(message);
    }

    /**
     * Constructor
     *
     * @param code Error code
     * @param message Message
     */
    public MachineException(ErrorCode code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * Constructor
     *
     * @param e Throable
     */
    public MachineException(Throwable e) {
        super(e);
    }

    /**
     * Constructor
     *
     * @param message Message
     * @param e Throable
     */
    public MachineException(String message, Throwable e) {
        super(message, e);
    }

    /**
     * Constructor
     *
     * @param code Error code
     * @param e Throable
     */
    public MachineException(ErrorCode code, Throwable e) {
        super(code.getDescription(), e);
        this.code = code;
    }

    /**
     * Constructor
     *
     * @param code Error code
     * @param message Message
     * @param e Throable
     */
    public MachineException(ErrorCode code, String message, Throwable e) {
        super(message, e);
        this.code = code;
    }
}