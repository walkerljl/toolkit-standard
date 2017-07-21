package org.walkerljl.toolkit.standard.exception;

/**
 * 错误码
 *
 * @author junlin.ljl
 * @version $Id: ErrorCode.java, v 0.1 2017年07月12日 下午4:10 junlin.ljl Exp $
 */
public interface ErrorCode {

    /**
     * 获取错误编码
     *
     * @return
     */
    String getCode();

    /**
     * 获取错误描述信息
     *
     * @return
     */
    String getDescription();
}