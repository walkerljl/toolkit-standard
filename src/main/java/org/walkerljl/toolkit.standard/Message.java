package org.walkerljl.toolkit.standard;

import java.io.Serializable;

/**
 * 消息对象
 *
 * <p>
 * 使用说明：<br/>
 * Message message = ....<br/>
 * if (message.isSuccess()) {//判断成功<br/>
 * T data = message.getData();//成功之后获取数据<br/>
 * <p>
 * } else {//失败<br/>
 * <br/>
 * }<br/>
 * message.getBody();//获取消息体,如：操作成功，操作失败<br/>
 * message.getCode();//获取消息响应码,如：200,404,500等，默认成功：200，失败：500<br/>
 *
 * @author lijunlin
 */
public class Message<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 默认成功编码
     */
    private static final String DEFAULT_SUCCESS_CODE = "200";
    /**
     * 默认失败编码
     */
    private static final String DEFAULT_FAILURE_CODE = "500";
    /**
     * 默认成功消息体
     */
    private static final String DEFAULT_SUCCESS_BODY = "操作成功";
    /**
     * 默认失败消息体
     */
    private static final String DEFAULT_FAILURE_BODY = "操作失败";

    /**
     * 消息码
     */
    private String code;
    /**
     * 消息体
     */
    private String body;
    /**
     * 消息结果
     */
    private boolean result = true;
    /**
     * 数据
     */
    private T data;

    /**
     * 默认构造函数
     */
    public Message() {}

    /**
     * 私有构造函数
     *
     * @param result 消息结果,true:成功,false:失败
     * @param code   消息码
     * @param body   消息体
     * @param data   数据
     */
    private Message(boolean result, String code, String body, T data) {
        this.result = result;
        this.code = code;
        this.body = body;
        this.data = data;
    }

    //自定义方法

    /**
     * 创建消息
     *
     * @param result 消息结果
     * @return
     */
    public static <T> Message<T> create(boolean result) {
        return Message.create(result,
            (result ? DEFAULT_SUCCESS_CODE : DEFAULT_FAILURE_CODE),
            (result ? DEFAULT_SUCCESS_BODY : DEFAULT_FAILURE_BODY), null);
    }

    /**
     * 创建消息
     *
     * @param result 消息结果
     * @param code 消息码
     * @param body 消息体
     * @param data 数据
     * @return
     */
    public static <T> Message<T> create(boolean result, String code, String body, T data) {
        return result ? Message.success(code, body, data) : Message.failure(code, body, data);
    }

    /**
     * 创建成功消息
     *
     * @return
     */
    public static <T> Message<T> success() {
        return Message.success(DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_BODY, null);
    }

    /**
     * 创建成功消息
     *
     * @param body 消息体
     * @return
     */
    public static <T> Message<T> success(String body) {
        return Message.success(DEFAULT_SUCCESS_CODE, body, null);
    }

    /**
     * 创建成功消息
     *
     * @param data 数据
     * @return
     */
    public static <T> Message<T> success(T data) {
        return Message.success(DEFAULT_SUCCESS_CODE, null, data);
    }

    /**
     * 创建成功消息
     *
     * @param body 消息体
     * @param data 数据
     * @return
     */
    public static <T> Message<T> success(String body, T data) {
        return new Message<T>(true, DEFAULT_SUCCESS_CODE, body, data);
    }

    /**
     * 创建成功消息
     *
     * @param code 消息码
     * @param body 消息体
     * @param data 数据
     * @return
     */
    public static <T> Message<T> success(String code, String body, T data) {
        return new Message<T>(true, code, body, data);
    }

    /**
     * 创建成功消息
     *
     * @param code 消息码
     * @param body 消息体
     * @return
     */
    public static <T> Message<T> success(String code, String body) {
        return new Message<T>(true, code, body, null);
    }

    /**
     * 创建失败消息
     *
     * @return
     */
    public static <T> Message<T> failure() {
        return Message.failure(DEFAULT_FAILURE_CODE, DEFAULT_FAILURE_BODY, null);
    }

    /**
     * 创建失败消息
     *
     * @param body 消息体
     * @return
     */
    public static <T> Message<T> failure(String body) {
        return Message.failure(DEFAULT_FAILURE_CODE, body, null);
    }

    /**
     * 创建失败消息
     *
     * @param body 消息体
     * @param data 数据
     * @return
     */
    public static <T> Message<T> failure(String body, T data) {
        return new Message<T>(false, DEFAULT_FAILURE_CODE, body, data);
    }

    /**
     * 创建失败消息
     *
     * @param data 数据
     * @return
     */
    public static <T> Message<T> failure(T data) {
        return new Message<T>(false, DEFAULT_FAILURE_CODE, DEFAULT_FAILURE_BODY, data);
    }

    /**
     * 创建失败消息
     *
     * @param code 消息码
     * @param body 消息对象
     * @param data 数据
     * @return
     */
    public static <T> Message<T> failure(String code, String body, T data) {
        return new Message<T>(false, code, body, data);
    }

    /**
     * 创建失败消息
     *
     * @param code 消息码
     * @param body 消息体
     * @return
     */
    public static <T> Message<T> failure(String code, String body) {
        return new Message<T>(false, code, body, null);
    }

    /**
     * 是否成功
     *
     * @return 成功：true，失败：false
     */
    public boolean isSuccess() {
        return result;
    }

    /**
     * 是否失败
     *
     * @return 失败：true，成功：false
     */
    public boolean isFailure() {
        return !isSuccess();
    }

    //setters and getters

    /**
     * 获取消息码
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置消息码
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取消息体
     *
     * @return
     */
    public String getBody() {
        return body;
    }

    /**
     * 设置消息体
     *
     * @param body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * 获取数据
     *
     * @return
     */
    public T getData() {
        return data;
    }

    /**
     * 设置数据
     *
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", body='" + body + '\'' +
                ", result=" + result +
                ", data=" + data +
                '}';
    }
}