package org.walkerljl.toolkit.standard.exception;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.walkerljl.toolkit.standard.BaseUnitTest;

/**
 *
 * @author junlin.ljl
 * @version $Id: AppServiceExceptionTest.java, v 0.1 2017年07月16日 下午4:09 junlin.ljl Exp $
 */
public class AppServiceExceptionTest extends BaseUnitTest {

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
        AppServiceException expected = new AppServiceException();
        Assert.assertNull(expected.getCode());

        expected = new AppServiceException(actualErrorMsg);
        Assert.assertEquals(expected.getMessage(), actualErrorMsg);

        Exception actualException = new RuntimeException();
        expected = new AppServiceException(actualException);
        Assert.assertTrue(actualException == expected.getCause());

        expected = new AppServiceException(actualErrorCode);
        Assert.assertTrue(expected.getCode() == actualErrorCode);

        expected = new AppServiceException(actualErrorCode, actualErrorMsg);
        Assert.assertEquals(expected.getMessage(), actualErrorMsg);
        Assert.assertTrue(expected.getCode() == actualErrorCode);

        expected = new AppServiceException(actualErrorMsg, actualException);
        Assert.assertEquals(expected.getMessage(), actualErrorMsg);
        Assert.assertTrue(actualException == expected.getCause());

        expected = new AppServiceException(actualErrorCode, actualErrorMsg, actualException);
        Assert.assertTrue(expected.getCode() == actualErrorCode);
        Assert.assertEquals(expected.getMessage(), actualErrorMsg);
        Assert.assertTrue(actualException == expected.getCause());

    }
}