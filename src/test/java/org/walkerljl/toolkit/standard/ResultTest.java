package org.walkerljl.toolkit.standard;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author lijunlin
 */
public class ResultTest {

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
    private static final String DEFAULT_SUCCESS_MESSAGE = "操作成功";
    /**
     * 默认失败消息体
     */
    private static final String DEFAULT_FAILURE_MESSAGE = "操作失败";

    private void assertDefaultFailure(Result<Integer> expected) {

        Assert.assertFalse(expected.isSuccess());
        Assert.assertTrue(expected.isFailure());
        Assert.assertEquals(expected.getMessage(), DEFAULT_FAILURE_MESSAGE);
        Assert.assertEquals(expected.getCode(), DEFAULT_FAILURE_CODE);
        Assert.assertEquals(expected.getData(), null);
    }

    private void assertDefaultSuccess(Result<Integer> expected) {

        Assert.assertTrue(expected.isSuccess());
        Assert.assertFalse(expected.isFailure());
        Assert.assertEquals(expected.getMessage(), DEFAULT_SUCCESS_MESSAGE);
        Assert.assertEquals(expected.getCode(), DEFAULT_SUCCESS_CODE);
        Assert.assertEquals(expected.getData(), null);
    }

    private void doAssert(Result<Integer> expected, boolean actualResult, String actualCode, String actualBody, Integer actualData) {

        if (actualResult) {
            Assert.assertTrue(expected.isSuccess());
            Assert.assertFalse(expected.isFailure());
        } else {
            Assert.assertFalse(expected.isSuccess());
            Assert.assertTrue(expected.isFailure());
        }
        Assert.assertEquals(expected.getMessage(), actualBody);
        Assert.assertEquals(expected.getCode(), actualCode);
        Assert.assertEquals(expected.getData(), actualData);
    }

    @Test
    public void create() {
        Result<Integer> expected = Result.create(false);
        assertDefaultFailure(expected);

        expected = Result.create(true);
        assertDefaultSuccess(expected);

        boolean actualResult = false;
        String actualCode = "1";
        String actualBody = "2";
        Integer actualData = 3;
        expected = Result.create(actualResult, actualCode, actualBody, actualData);
        doAssert(expected, actualResult, actualCode, actualBody, actualData);

        actualResult = true;
        expected = Result.create(actualResult, actualCode, actualBody, actualData);
        doAssert(expected, actualResult, actualCode, actualBody, actualData);
    }

    @Test
    public void success() {
        boolean actualResult = true;
        String actualCode = "1";
        String actualBody = "2";
        Integer actualData = 3;
        Result<Integer> expected = null;

        expected = Result.success();
        doAssert(expected, actualResult, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, null);

        expected = Result.success(actualBody);
        doAssert(expected, actualResult, DEFAULT_SUCCESS_CODE, actualBody, null);

        expected = Result.success(actualData);
        doAssert(expected, actualResult,  DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, actualData);

        expected = Result.success(actualCode, actualBody);
        doAssert(expected, actualResult, actualCode, actualBody, null);

        expected = Result.success(actualBody, actualData);
        doAssert(expected, actualResult, DEFAULT_SUCCESS_CODE, actualBody, actualData);

        expected = Result.success(actualCode, actualBody, actualData);
        doAssert(expected, actualResult, actualCode, actualBody, actualData);
    }

    @Test
    public void failue() {

        boolean actualResult = false;
        String actualCode = "1";
        String actualBody = "2";
        Integer actualData = 3;
        Result<Integer> expected = null;

        expected = Result.failure();
        doAssert(expected, actualResult, DEFAULT_FAILURE_CODE, DEFAULT_FAILURE_MESSAGE, null);

        expected = Result.failure(actualBody);
        doAssert(expected, actualResult, DEFAULT_FAILURE_CODE, actualBody, null);

        expected = Result.failure(actualData);
        doAssert(expected, actualResult,  DEFAULT_FAILURE_CODE, DEFAULT_FAILURE_MESSAGE, actualData);

        expected = Result.failure(actualCode, actualBody);
        doAssert(expected, actualResult, actualCode, actualBody, null);

        expected = Result.failure(actualBody, actualData);
        doAssert(expected, actualResult, DEFAULT_FAILURE_CODE, actualBody, actualData);

        expected = Result.failure(actualCode, actualBody, actualData);
        doAssert(expected, actualResult, actualCode, actualBody, actualData);
    }
}