package testSuites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import tests.TestLogin;
import tests.TestSignOut;

@RunWith(JUnitPlatform.class)

@SelectClasses({
        TestLogin.class,
        TestSignOut.class
})

public class TestSuiteLogin {
}
