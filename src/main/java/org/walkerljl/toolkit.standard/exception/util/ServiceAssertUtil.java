package org.walkerljl.toolkit.standard.exception.util;

import org.walkerljl.toolkit.standard.exception.AppServiceException;
import org.walkerljl.toolkit.standard.exception.code.ErrorCode;

/**
 * ServiceAssertUtil
 *
 * @author xingxun
 * @Date 2017/10/22
 */
public class ServiceAssertUtil {

    /**
     * 断言为真
     *
     * @param expression 表达式
     * @param message 消息
     */
    public static void assertTrue(boolean expression, String message) {
        if (!expression) {
            throw new AppServiceException(message);
        }
    }

    /**
     * 断言为真
     *
     * @param expression 表达式
     * @param errorCode 错误码
     */
    public static void assertTrue(boolean expression, ErrorCode errorCode) {
        if (!expression) {
            throw new AppServiceException(errorCode);
        }
    }

    /**
     * 断言为真
     *
     * @param expression 表达式
     * @param errorCode 错误码
     * @param message 消息
     */
    public static void assertTrue(boolean expression, ErrorCode errorCode, String message) {
        if (!expression) {
            throw new AppServiceException(errorCode, message);
        }
    }
}
