package testcases;

import org.testng.annotations.Test;

public class TestNgGroupsExample {
    //here we will use (groups) it is similar to (Tags) in cucumber but we can't use (Tags) with testNg

    @Test(groups = "smokeTest")
    public void verifyLogin(){
        System.out.println("Verify Login");
    }

    @Test(groups = "smokeTest")
    public void verifySignOut(){
        System.out.println("Verify Signout");
    }

    @Test(groups = "regression")
    public void verifyDashboard(){
        System.out.println("verify dashboard");
    }

    @Test(groups = "regression")
    public void verifyProductLabel(){
        System.out.println("verify Product label");
    }


}
