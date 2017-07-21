package org.walkerljl.toolkit.standard;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author junlin.ljl
 * @version $Id: MessageTest.java, v 0.1 2017年07月16日 上午10:41 junlin.ljl Exp $
 */
public class MessageTest {

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

    private void assertDefaultFailure(Message<Integer> expected) {

        Assert.assertFalse(expected.isSuccess());
        Assert.assertTrue(expected.isFailure());
        Assert.assertEquals(expected.getBody(), DEFAULT_FAILURE_BODY);
        Assert.assertEquals(expected.getCode(), DEFAULT_FAILURE_CODE);
        Assert.assertEquals(expected.getData(), null);
    }

    private void assertDefaultSuccess(Message<Integer> expected) {

        Assert.assertTrue(expected.isSuccess());
        Assert.assertFalse(expected.isFailure());
        Assert.assertEquals(expected.getBody(), DEFAULT_SUCCESS_BODY);
        Assert.assertEquals(expected.getCode(), DEFAULT_SUCCESS_CODE);
        Assert.assertEquals(expected.getData(), null);
    }

    private void doAssert(Message<Integer> expected, boolean actualResult, String actualCode, String actualBody, Integer actualData) {

        if (actualResult) {
            Assert.assertTrue(expected.isSuccess());
            Assert.assertFalse(expected.isFailure());
        } else {
            Assert.assertFalse(expected.isSuccess());
            Assert.assertTrue(expected.isFailure());
        }
        Assert.assertEquals(expected.getBody(), actualBody);
        Assert.assertEquals(expected.getCode(), actualCode);
        Assert.assertEquals(expected.getData(), actualData);
    }

    @Test
    public void create() {
        Message<Integer> expected = Message.create(false);
        assertDefaultFailure(expected);

        expected = Message.create(true);
        assertDefaultSuccess(expected);

        boolean actualResult = false;
        String actualCode = "1";
        String actualBody = "2";
        Integer actualData = 3;
        expected = Message.create(actualResult, actualCode, actualBody, actualData);
        doAssert(expected, actualResult, actualCode, actualBody, actualData);

        actualResult = true;
        expected = Message.create(actualResult, actualCode, actualBody, actualData);
        doAssert(expected, actualResult, actualCode, actualBody, actualData);
    }

    @Test
    public void success() {
        boolean actualResult = true;
        String actualCode = "1";
        String actualBody = "2";
        Integer actualData = 3;
        Message<Integer> expected = null;

        expected = Message.success();
        doAssert(expected, actualResult, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_BODY, null);

        expected = Message.success(actualBody);
        doAssert(expected, actualResult, DEFAULT_SUCCESS_CODE, actualBody, null);

        expected = Message.success(actualData);
        doAssert(expected, actualResult,  DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_BODY, actualData);

        expected = Message.success(actualCode, actualBody);
        doAssert(expected, actualResult, actualCode, actualBody, null);

        expected = Message.success(actualBody, actualData);
        doAssert(expected, actualResult, DEFAULT_SUCCESS_CODE, actualBody, actualData);

        expected = Message.success(actualCode, actualBody, actualData);
        doAssert(expected, actualResult, actualCode, actualBody, actualData);
    }

    @Test
    public void failue() {

        boolean actualResult = false;
        String actualCode = "1";
        String actualBody = "2";
        Integer actualData = 3;
        Message<Integer> expected = null;

        expected = Message.failure();
        doAssert(expected, actualResult, DEFAULT_FAILURE_CODE, DEFAULT_FAILURE_BODY, null);

        expected = Message.failure(actualBody);
        doAssert(expected, actualResult, DEFAULT_FAILURE_CODE, actualBody, null);

        expected = Message.failure(actualData);
        doAssert(expected, actualResult,  DEFAULT_FAILURE_CODE, DEFAULT_FAILURE_BODY, actualData);

        expected = Message.failure(actualCode, actualBody);
        doAssert(expected, actualResult, actualCode, actualBody, null);

        expected = Message.failure(actualBody, actualData);
        doAssert(expected, actualResult, DEFAULT_FAILURE_CODE, actualBody, actualData);

        expected = Message.failure(actualCode, actualBody, actualData);
        doAssert(expected, actualResult, actualCode, actualBody, actualData);
    }
}