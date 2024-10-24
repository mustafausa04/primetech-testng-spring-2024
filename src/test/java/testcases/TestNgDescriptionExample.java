package testcases;

import org.testng.annotations.Test;

public class TestNgDescriptionExample {
    //here we can add this attribute (description) to describe what the test case about but we will not be able to see
    //it in the console it will be only on the report.
    //also we can combined multi attributes at once like below

    @Test(priority = 1 , description = "Positive test case for the login scenario")
    public void test(){
        System.out.println("Dummy test");
    }

}
