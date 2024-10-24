package testcases;

import org.testng.annotations.Test;

public class TestNgPrioritiesExample {
    //testng will execute test cases according to alphabetical so in the test below we will get

    //this will be third
    // @Test
    //    public void test2(){
    //        System.out.println("This is test 2");
    //    }
    //this will be first
    //    @Test
    //    public void abc(){
    //        System.out.println("This is test 3");
    //    }
    //this will be second
    //    @Test
    //    public void test1(){
    //        System.out.println("This is test 1");
    //    }

    //here we could put priority to execute any one we want first, second ...
    //this will be first
    @Test(priority = 1)
    public void test2(){
        System.out.println("This is test 2");
    }
    //this will be second
    @Test(priority = 2)
    public void abc(){
        System.out.println("This is test 3");
    }
    //this will be third
    @Test(priority = 3)
    public void test1(){
        System.out.println("This is test 1");
    }

}
