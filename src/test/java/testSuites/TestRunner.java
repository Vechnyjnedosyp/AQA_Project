package testSuites;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result resultLogin = JUnitCore.runClasses(TestSuiteLogin.class);
        for (Failure failure : resultLogin.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultLogin.wasSuccessful());


        Result resultAddresses = JUnitCore.runClasses(TestSuiteAddresses.class);
        for (Failure failure : resultAddresses.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(resultAddresses.wasSuccessful());
    }
}
