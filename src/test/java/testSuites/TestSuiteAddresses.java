package testSuites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import tests.TestDestroyAddress;
import tests.TestEditAddress;
import tests.TestNewAddress;

@RunWith(JUnitPlatform.class)

@SelectClasses({
        TestNewAddress.class,
        TestEditAddress.class,
        TestDestroyAddress.class
})

public class TestSuiteAddresses {
}
