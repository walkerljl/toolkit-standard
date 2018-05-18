package org.walkerljl.toolkit.standard.exception;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.walkerljl.toolkit.standard.exception.code.ErrorCode;

/**
 *
 * @author xingxun
 */
public class SwallowedAppExceptionTest {

    @Test
    public void test() {

        ErrorCode actualErrorCode = new ErrorCode() {
            @Override
            public String getCode() {
                return "code";
            }

            @Override
            public String getDescription() {
                return "description";
            }
        };

        String actualErrorMsg = "errorMsg";
        SwallowedAppException expected = new SwallowedAppException();
        Assert.assertNull(expected.getCode());

        expected = new SwallowedAppException(actualErrorMsg);
        Assert.assertEquals(expected.getMessage(), actualErrorMsg);

        Exception actualException = new RuntimeException();
        expected = new SwallowedAppException(actualException);
        Assert.assertTrue(actualException == expected.getCause());

        expected = new SwallowedAppException(actualErrorCode);
        Assert.assertTrue(expected.getCode() == actualErrorCode);

        expected = new SwallowedAppException(actualErrorCode, actualErrorMsg);
        Assert.assertEquals(expected.getMessage(), actualErrorMsg);
        Assert.assertTrue(expected.getCode() == actualErrorCode);

        expected = new SwallowedAppException(actualErrorMsg, actualException);
        Assert.assertEquals(expected.getMessage(), actualErrorMsg);
        Assert.assertTrue(actualException == expected.getCause());

        expected = new SwallowedAppException(actualErrorCode, actualErrorMsg, actualException);
        Assert.assertTrue(expected.getCode() == actualErrorCode);
        Assert.assertEquals(expected.getMessage(), actualErrorMsg);
        Assert.assertTrue(actualException == expected.getCause());
    }
}