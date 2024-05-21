package testng;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_AlwayRun {
    @BeforeClass(alwaysRun = true)
    public void init(){
        System.out.println("Pre-condition for bellow testcases");
    }

    @Test(groups = "category")
    public void testCreateNewCategoryEmpty(){

    }
    @Test(groups = "category")
    public void testCreateNewCategoryNameEmptyAndDescript(){

    }
    @AfterClass(alwaysRun = true)
    public void after(){
        System.out.println("Post-condition for bellow testcases");
    }


}
