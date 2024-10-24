package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgDependentOnExample {
    //the (dependentOnMethods) will execute the test case that is dependent on another test case for ex the second test
    //case is dependent on the first one so if the first one failed the second won't be executed but if the first one
    //was pss then the second test case will be executed

    @Test()
    public void login(){
        //we can fail the test by doing the below
        Assert.assertTrue(false);
    }

    //this will depend on the one above
    @Test(dependsOnMethods = "login")
    public void login2(){
        Assert.assertTrue(false);
    }

    //this will depends on test case login2
    @Test(dependsOnMethods = "login2")// this will run only if login test case passed
    public void verifyDashboard(){
        System.out.println("Dashboard is verified successfully");
    }

    //this will depends on 2 different test cases
    //@Test(dependsOnMethods = {"login","login2"})
    //public void verifyDashboard(){
    //    System.out.println("Dashboard is verified successfully");
    //}


}
