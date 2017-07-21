package org.walkerljl.toolkit.standard.exception;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.walkerljl.toolkit.standard.BaseUnitTest;

/**
 *
 * @author junlin.ljl
 * @version $Id: AppRpcExceptionTest.java, v 0.1 2017年07月16日 下午4:08 junlin.ljl Exp $
 */
public class AppRpcExceptionTest extends BaseUnitTest {

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
        AppRpcException expected = new AppRpcException();
        Assert.assertNull(expected.getCode());

        expected = new AppRpcException(actualErrorMsg);
        Assert.assertEquals(expected.getMessage(), actualErrorMsg);

        Exception actualException = new RuntimeException();
        expected = new AppRpcException(actualException);
        Assert.assertTrue(actualException == expected.getCause());

        expected = new AppRpcException(actualErrorCode);
        Assert.assertTrue(expected.getCode() == actualErrorCode);

        expected = new AppRpcException(actualErrorCode, actualErrorMsg);
        Assert.assertEquals(expected.getMessage(), actualErrorMsg);
        Assert.assertTrue(expected.getCode() == actualErrorCode);

        expected = new AppRpcException(actualErrorMsg, actualException);
        Assert.assertEquals(expected.getMessage(), actualErrorMsg);
        Assert.assertTrue(actualException == expected.getCause());

        expected = new AppRpcException(actualErrorCode, actualErrorMsg, actualException);
        Assert.assertTrue(expected.getCode() == actualErrorCode);
        Assert.assertEquals(expected.getMessage(), actualErrorMsg);
        Assert.assertTrue(actualException == expected.getCause());

    }

}