package org.walkerljl.toolkit.standard.exception.util;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.walkerljl.toolkit.standard.BaseUnitTest;
import org.walkerljl.toolkit.standard.exception.AppException;
import org.walkerljl.toolkit.standard.exception.code.ErrorCode;

/**
 * AssertUtilsTest
 *
 * @author lijunlin
 * @Date 2017/10/22
 */
public class AssertUtilsTest extends BaseUnitTest {

    @Test
    public void test() {
        ErrorCode errorCode = new ErrorCode() {
            @Override
            public String getCode() {
                return "errorCode";
            }

            @Override
            public String getDescription() {
                return "errorDescription";
            }
        };
        String message = "message";

        AssertUtil.assertTrue(true, errorCode, message);
        AssertUtil.assertTrue(true, errorCode);
        AssertUtil.assertTrue(true, message);

        boolean result = false;
        try {
            AssertUtil.assertTrue(false, errorCode, message);
        } catch (AppException e) {
            if (message.equals(e.getMessage())
                    && errorCode.getCode().equals(e.getCode().getCode())
                    && errorCode.getDescription().equals(e.getCode().getDescription())) {
                result = true;
            }
        }
        Assert.assertTrue(result);
        result = false;

        try {
            AssertUtil.assertTrue(false, errorCode);
        } catch (AppException e) {
            if (errorCode.getDescription().equals(e.getMessage())
                    && errorCode.getCode().equals(e.getCode().getCode())
                    && errorCode.getDescription().equals(e.getCode().getDescription())) {
                result = true;
            }
        }
        Assert.assertTrue(result);
        result = false;

        try {
            AssertUtil.assertTrue(false, message);
        } catch (AppException e) {
            if (message.equals(e.getMessage())
            && e.getCode() == null) {
                result = true;
            }
        }
        Assert.assertTrue(result);
    }
}