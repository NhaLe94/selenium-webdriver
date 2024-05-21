package testng;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Description {
    @BeforeClass(alwaysRun = true)
    public void init(){
        System.out.println("Pre-condition for bellow testcases");
    }

    @Test(description = "JIRA#1109 - Create a new category with empty")
    public void test_01_CreateNewCategoryEmpty(){

    }
    @Test
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
