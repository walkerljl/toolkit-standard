package org.walkerljl.toolkit.standard.util;

import org.walkerljl.toolkit.standard.exception.AppException;
import org.walkerljl.toolkit.standard.exception.ErrorCode;

/**
 *
 * @author lijunlin
 */
public class AssertUtils {

    /**
     * 判断是否为真
     *
     * @param expression 表达式
     * @param message 消息
     */
    public static void assertTrue(boolean expression, String message) {

        assertTrue(expression, null, message);
    }

    /**
     * 判断是否为真
     *
     * @param expression 表达式
     * @param errorCode 错误码
     */
    public static void assertTrue(boolean expression, ErrorCode errorCode) {

        if (!expression) {
            throw new AppException(errorCode);
        }
    }

    /**
     * 判断是否为真
     *
     * @param expression 表达式
     * @param errorCode 错误码
     * @param message 消息
     */
    public static void assertTrue(boolean expression, ErrorCode errorCode, String message) {

        if (!expression) {
            throw new AppException(errorCode, message);
        }
    }
}