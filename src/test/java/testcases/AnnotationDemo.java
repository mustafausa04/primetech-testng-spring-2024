package testcases;

import org.testng.annotations.*;

public class AnnotationDemo {

    @Test
    void test1(){
        System.out.println("@ Test annotation for test1");
    }

    @Test
    void test2(){
        System.out.println("@ Test annotation for test2");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("@ BeforeMethod annotation");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("@ AfterMethod annotation");
    }

    @BeforeClass
    void beforeClass(){
        System.out.println("@ BeforeClass annotation");
    }

    @AfterClass
    void afterClass(){
        System.out.println("@ AfterClass annotation");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("@ BeforeTest annotation");
    }

    @AfterTest
    void afterTest(){
        System.out.println("@ AfterTest annotation");
    }

    @BeforeSuite
    void beforeSuite(){
        System.out.println("@ BeforeSuite annotation");
    }

    @AfterSuite
    void afterSuite(){
        System.out.println("@ AfterSuite annotation");
    }

}
