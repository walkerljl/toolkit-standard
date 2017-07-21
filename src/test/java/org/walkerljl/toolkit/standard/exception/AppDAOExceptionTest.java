package org.walkerljl.toolkit.standard.exception;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author junlin.ljl
 * @version $Id: AppDAOExceptionTest.java, v 0.1 2017年07月16日 下午4:06 junlin.ljl Exp $
 */
public class AppDAOExceptionTest {

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
        AppDAOException expected = new AppDAOException();
        Assert.assertNull(expected.getCode());

        expected = new AppDAOException(actualErrorMsg);
        Assert.assertEquals(expected.getMessage(), actualErrorMsg);

        Exception actualException = new RuntimeException();
        expected = new AppDAOException(actualException);
        Assert.assertTrue(actualException == expected.getCause());

        expected = new AppDAOException(actualErrorCode);
        Assert.assertTrue(expected.getCode() == actualErrorCode);

        expected = new AppDAOException(actualErrorCode, actualErrorMsg);
        Assert.assertEquals(expected.getMessage(), actualErrorMsg);
        Assert.assertTrue(expected.getCode() == actualErrorCode);

        expected = new AppDAOException(actualErrorMsg, actualException);
        Assert.assertEquals(expected.getMessage(), actualErrorMsg);
        Assert.assertTrue(actualException == expected.getCause());

        expected = new AppDAOException(actualErrorCode, actualErrorMsg, actualException);
        Assert.assertTrue(expected.getCode() == actualErrorCode);
        Assert.assertEquals(expected.getMessage(), actualErrorMsg);
        Assert.assertTrue(actualException == expected.getCause());

    }
}