package org.walkerljl.toolkit.standard.exception.resouce;

import org.walkerljl.toolkit.standard.exception.AppException;
import org.walkerljl.toolkit.standard.exception.code.ErrorCode;

/**
 * Exception of resource
 *
 * @author xingxun
 */
public class ResourceException extends AppException {

    private static final long serialVersionUID = -6786549876849535944L;

    /**
     * Constructor
     */
    public ResourceException() {
        super();
    }

    /**
     * Constructor
     *
     * @param message Message
     */
    public ResourceException(String message) {
        super(message);
    }

    /**
     * Constructor
     *
     * @param code Error code
     * @param message Message
     */
    public ResourceException(ErrorCode code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * Constructor
     *
     * @param e Throable
     */
    public ResourceException(Throwable e) {
        super(e);
    }

    /**
     * Constructor
     *
     * @param message Message
     * @param e Throable
     */
    public ResourceException(String message, Throwable e) {
        super(message, e);
    }

    /**
     * Constructor
     *
     * @param code Error code
     * @param e Throable
     */
    public ResourceException(ErrorCode code, Throwable e) {
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
    public ResourceException(ErrorCode code, String message, Throwable e) {
        super(message, e);
        this.code = code;
    }
}