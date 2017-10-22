package org.walkerljl.toolkit.standard.exception.util;

import org.walkerljl.toolkit.standard.exception.AppServiceException;
import org.walkerljl.toolkit.standard.exception.ErrorCode;

/**
 * ServiceAssertUtils
 *
 * @author lijunlin
 * @Date 2017/10/22
 */
public class ServiceAssertUtils {

    /**
     * 断言表达式为真
     *
     * @param expression 表达式
     * @param message 错误消息
     */
    public static void assertTrue(boolean expression, String message) {
        assertTrue(expression, null, message);
    }

    /**
     * 断言表达式为真
     *
     * @param expression 表达式
     * @param errorCode 错误码
     */
    public static void assertTrue(boolean expression, ErrorCode errorCode) {
        assertTrue(expression, errorCode, null);
    }

    /**
     * 断言表达式为真
     *
     * @param expression 表达式
     * @param errorCode 错误码
     * @param message 异常消息
     */
    public static void assertTrue(boolean expression, ErrorCode errorCode, String message) {
        if (expression) {
            return;
        }
        throw new AppServiceException(errorCode, message);
    }
}
