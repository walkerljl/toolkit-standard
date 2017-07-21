package org.walkerljl.toolkit.standard.exception;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author junlin.ljl
 * @version $Id: AppExceptionTest.java, v 0.1 2017年07月12日 下午4:16 junlin.ljl Exp $
 */
public class AppExceptionTest {

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
        AppException expected = new AppException();
        Assert.assertNull(expected.getCode());

        expected = new AppException(actualErrorMsg);
        Assert.assertEquals(expected.getMessage(), actualErrorMsg);

        Exception actualException = new RuntimeException();
        expected = new AppException(actualException);
        Assert.assertTrue(actualException == expected.getCause());

        expected = new AppException(actualErrorCode);
        Assert.assertTrue(expected.getCode() == actualErrorCode);

        expected = new AppException(actualErrorCode, actualErrorMsg);
        Assert.assertEquals(expected.getMessage(), actualErrorMsg);
        Assert.assertTrue(expected.getCode() == actualErrorCode);

        expected = new AppException(actualErrorMsg, actualException);
        Assert.assertEquals(expected.getMessage(), actualErrorMsg);
        Assert.assertTrue(actualException == expected.getCause());

        expected = new AppException(actualErrorCode, actualErrorMsg, actualException);
        Assert.assertTrue(expected.getCode() == actualErrorCode);
        Assert.assertEquals(expected.getMessage(), actualErrorMsg);
        Assert.assertTrue(actualException == expected.getCause());
    }

}