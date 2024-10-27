package testcases;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgParameterExample {
    //if we run this class from here without adding (@Optional) to the parameters it will give us error so we add those
    //(@Optional) annotation just to get rid of the error because the class here if we run it from here it will treat
    //the parameters String firstname and String lastname as a null because we didn't pass any value into them. but
    //if we run this from the (RunTestNGUsingParameters.xml) at that time we will get the values of ("aaa", "bbb")
    //which are (Mohamed Nheri)

    @Test
    @Parameters({"aaa", "bbb"})
    public void demoTest(@Optional String firstname, @Optional String lastname){
        System.out.println(firstname);
        System.out.println(lastname);
    }

}
