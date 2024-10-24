package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssert_SoftAssertDemo {
    //--------------------------------Hard assertion
    //we will call (hard assert) to any assertion in testng, in cucumber we call it only (assertion)
    //A Hard Assertion is a type of assertion that throws an exception immediately when an assert statement fails.
    // Test steps after hard assertion will not be executed and the next test in the test suite will start.
    //Soft Assertions are the type of assertions that do not throw an exception immediately when an assertion fails.
    //Therefore, all steps and soft assertions in the automated test will execute before failing the test.

    @Test
    public void hardAssertExample() {
        //--------------------------------Hard assertion
        //Verification 1
        //since 4 is not equal to 3 the assertion will be false and since it will fail then it won't go execute the next
        //line which is line 22 and after
        Assert.assertTrue(4 == 3);
        //Assert.assertTrue(4==4);//this will pass and execute the next line

        //Verification 2
        //the message will not print because the previous test is failed
        System.out.println("This line will not execute because previous assert444");
        Assert.assertTrue(6 > 5); //true this assertion should pass
    }


    @Test
    public void softAssertExample() {
        //--------------------------------Soft assertion
        //we need to create an object of the class SoftAssert because its methods there are not static so non static
        //method we call them by creating an object but the one above the hard assertion the class there (Assert) has
        //its methods are static so we just call the method by its class like (Assert.)
        SoftAssert softAssert = new SoftAssert();

        //soft assert will pass all the tests even if there is one failed so we have to put this  softAssert.assertAll();
        //at the end to tell us which test is failed

        //Verification 1
        //this will fail, we can also add another parameter and add a message in it
        softAssert.assertTrue(4 == 3, "verifying 4 is equal to 3");

        //Verification 2
        //the message will print even if the previous assertion was failed
        System.out.println("This line will  execute even after previous assertion failed");
        //this will pass, we can also add another parameter and add a message in it
        softAssert.assertTrue(6 > 5, "verifying 6 greater than 5");

        //Verification 3
        //this will fail, we can also add another parameter and add a message in it
        softAssert.assertEquals("PrimeTech", "Prime", "verifying primetech is equal to prime");

        //we have to put this at the end to know which test is failed
        softAssert.assertAll();
    }
}

    //we could use those assertion too
    //Assert.assertEquals()
    //Assert.assertNotEquals()
    //Assert.assertNull()
    //Assert.assertNotNull()
    //Assert.assertTrue()
    //Assert.assertFalse()