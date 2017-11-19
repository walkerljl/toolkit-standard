package org.walkerljl.toolkit.standard.exception.code;

import org.walkerljl.toolkit.standard.enums.IEnum;

/**
 * App error code
 *
 * @author lijunlin
 */
public enum AppErrorCode implements IEnum {


    ;

    /** 编码*/
    private String code;
    /** 描述*/
    private String description;

    /**
     * 构造函数
     *
     * @param code 编码
     * @param description 描述
     */
    AppErrorCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * 根据编码获取枚举对象
     *
     * @param code 编码
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