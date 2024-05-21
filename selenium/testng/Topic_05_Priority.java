package testng;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Priority {
    @BeforeClass(alwaysRun = true)
    public void init(){
        System.out.println("Pre-condition for bellow testcases");
    }

    @Test(priority = 0)
    public void test_01_CreateNewCategoryEmpty(){

    }
    @Test(priority = 1)
    public void test_02_CreateNewCategoryNameEmptyAndDescript(){

    }
    @Test(priority = 2)
    public void test_03_CreateNewCategoryNameEmptyAndImage(){

    }
    @AfterClass(alwaysRun = true)
    public void after(){
        System.out.println("Post-condition for bellow testcases");
    }
}
