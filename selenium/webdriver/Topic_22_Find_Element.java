package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_22_Find_Element {

    WebDriver driver;
    WebDriverWait explicitWait;


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        // implicit wait
        //set implicit = selenium vr 4.x tro len
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_01_FindElement() {
        // Case 1: element được tìm thấy chỉ có 1
        // sẽ không cần chờ hét timeout
        // tìm thấy sẽ trả ve 1 webelement
        // qa step tiếp theo
       // driver.findElement(By.cssSelector("input#email"));

        // case2: element được tìm thấy nhưng có nhiều hơn 1
        // sẽ không cần chờ hét timeout
        // lấy cái element đầu tiên dù có cả n node
        // qa step tiếp theo
//        System.out.println("Start step: " + getDateTimeNow());
//        driver.findElement(By.cssSelector("input[type='text'],[type='password']")).sendKeys("nha@gmail.com");
//        System.out.println("End step: " + getDateTimeNow());

        // case3: element k tim thay
        // cho het time out la 10s
        //trong thoi gian 10s nay cu moi nua giay se tim lai 1 lan
        //neu tim lai ma thay thi cung tra ve element roi qua step tiep theo
        // neu tim lai ma k tim thay thi danh fail tcs va throw exception: nosuchElementException
        // cac step con lai k chay nua
        driver.findElement(By.cssSelector("input[name='req_email__']"));

    }

    @Test
    public void TC_02_FindElements() {
        List<WebElement> elementList;
        //case 1: element dc timt hay chi co 1
        // k can cho het timeout 10s
        // tra ve list element chua dung 1 element

//        System.out.println("Start step: " + getDateTimeNow());
//        elementList=driver.findElements(By.cssSelector("input#email"));
//        System.out.println("List have: " + elementList.size());
//        System.out.println("End step: " + getDateTimeNow());

        //case2: element dc tim thay nhung co nhieu hon 1
        // k can cho het timeout 10s
        // tra ve list element chua nhieu element
//        System.out.println("Start step: " + getDateTimeNow());
//        elementList=driver.findElements(By.cssSelector("input[type='text'],[type='password']"));
//        System.out.println("List have: " + elementList.size());
//        System.out.println("End step: " + getDateTimeNow());


        // case3: element k dc tim thay
        // cho het timeout la 10s
        // moi nua giay cung tim lai 1 lan(polling)
        // neu trong thoi gian tim lai ma thay thi cung tra ve lisst chua co element
        // neu het thoi gian tim lai ma k tim thay thi cung tra ve list rong va k danh fail tcs
        // qua step tiep theo
        System.out.println("Start step: " + getDateTimeNow());
        elementList=driver.findElements(By.cssSelector("input[name='req_email__']"));
        System.out.println("List have: " + elementList.size());

    }

    @Test
    public void TC_03_Form() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepSeconds(long timeInsecond) {
        try {
            Thread.sleep(timeInsecond *1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String getDateTimeNow(){
        Date date = new Date();
        return  date.toString();
    }
}
