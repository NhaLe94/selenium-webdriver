package testng;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Skip {
    @BeforeClass(alwaysRun = true)
    public void init(){
        System.out.println("Pre-condition for bellow testcases");
    }

    @Test
    public void test_01_CreateNewCategoryEmpty(){

    }
    @Test(enabled = false)
    public void test_02_CreateNewCategoryNameEmptyAndDescript(){

    }
    @Test
    public void test_03_CreateNewCategoryNameEmptyAndImage(){

    }
    @AfterClass(alwaysRun = true)
    public void after(){
        System.out.println("Post-condition for bellow testcases");
    }
}
