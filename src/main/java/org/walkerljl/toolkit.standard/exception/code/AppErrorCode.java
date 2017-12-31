package org.walkerljl.toolkit.standard.exception.code;

import org.walkerljl.toolkit.standard.enums.IEnum;

/**
 * App error code
 *
 * @author xingxun
 */
public enum AppErrorCode implements IEnum {


    ;

    /** Code*/
    private String code;
    /** Description*/
    private String description;

    /**
     * Constructor
     *
     * @param code Code
     * @param description Description
     */
    AppErrorCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Get by code
     *
     * @param code Code
     * @return
     */
    public static AppErrorCode getByCode(String code) {
        for (AppErrorCode errorCode : AppErrorCode.values()) {
            if (errorCode.getCode().equalsIgnoreCase(code)) {
                return errorCode;
            }
        }
        return null;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }
}