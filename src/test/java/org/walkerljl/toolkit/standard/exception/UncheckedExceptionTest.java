package org.walkerljl.toolkit.standard.exception;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.walkerljl.toolkit.standard.BaseUnitTest;

/**
 *
 * @author junlin.ljl
 * @version $Id: UncheckedExceptionTest.java, v 0.1 2017年07月16日 下午4:09 junlin.ljl Exp $
 */
public class UncheckedExceptionTest extends BaseUnitTest {

    @Test
    public void test() {

        String errorMsg = "errorMsg";
        UncheckedException expected = new UncheckedException();
        //Assert.assertTrue(expected.getCause() == expected);

        expected = new UncheckedException(errorMsg);
        Assert.assertEquals(expected.getMessage(), errorMsg);

        Exception actualException = new RuntimeException();
        expected = new UncheckedException(actualException);
        Assert.assertTrue(actualException == expected.getCause());

        expected = new UncheckedException(errorMsg, actualException);
        Assert.assertEquals(expected.getMessage(), errorMsg);
        Assert.assertTrue(actualException == expected.getCause());
    }
}