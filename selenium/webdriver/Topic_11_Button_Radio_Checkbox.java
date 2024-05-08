package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_11_Button_Radio_Checkbox {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {

        if (osName.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
        }

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Url() {
        driver.get("https://egov.danang.gov.vn/reg");

        WebElement registerButton = driver.findElement(By.cssSelector("input.egov-button"));
        // verify button disabled khi chua click vào checkbox
        Assert.assertFalse(registerButton.isEnabled());
        driver.findElement(By.cssSelector("input#chinhSach")).click();

        // verify button enabled khi click vào checkbox
        Assert.assertTrue(registerButton.isEnabled());

        // lay ra ma mau nen cua button

        String registerBackgroundColorCode = registerButton.getCssValue("background-color");
        System.out.println("Background Color = " + registerBackgroundColorCode);
        Color registerBackgroundColor = Color.fromString(registerBackgroundColorCode);
        String registerBackgroundHexa = registerBackgroundColor.asHex();
        System.out.println("Background color hexa = " + registerBackgroundHexa);
        System.out.println("Background color hexa = " + registerBackgroundHexa.toUpperCase());
        System.out.println("Background color hexa = " + registerBackgroundHexa.toLowerCase());
        Assert.assertEquals(registerBackgroundHexa.toLowerCase(), "#ef5a00");

    }

    @Test
    public void TC_02_Fahasa_Button() {
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        WebElement loginButton = driver.findElement(By.cssSelector("button.fhs-btn-login"));
        Assert.assertFalse(loginButton.isEnabled());
        System.out.println(loginButton.getCssValue("background-color"));

        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(), "#000000");
        driver.findElement(By.cssSelector("input#login_username")).sendKeys("lelucy90@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456");
        Assert.assertTrue(loginButton.isEnabled());
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(), "#c92127");
    }

    @Test
    public void TC_03_Default_Telerik_Checkbox() {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        By rearSideCheckbox = By.xpath("//label[text()='Rear side airbags']/preceding-sibling::span/input");
        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");

       checkToElement(rearSideCheckbox);
       checkToElement(dualZoneCheckbox);

        Assert.assertTrue(driver.findElement(rearSideCheckbox).isSelected());
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());

        uncheckToElement(rearSideCheckbox);
        uncheckToElement(dualZoneCheckbox);

        Assert.assertFalse(driver.findElement(rearSideCheckbox).isSelected());
        Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());
    }

    @Test
    public void TC_04_Default_Egov_Checkbox() {
        driver.get("https://egov.danang.gov.vn/reg");
        By chinhSanhCheckbox = By.xpath("//input[@id='chinhSach']");

        if (!driver.findElement(chinhSanhCheckbox).isSelected()) {
            driver.findElement(chinhSanhCheckbox).click();
            sleepSeconds(2);
        }

        Assert.assertTrue(driver.findElement(chinhSanhCheckbox).isSelected());

        if (driver.findElement(chinhSanhCheckbox).isSelected()) {
            driver.findElement(chinhSanhCheckbox).click();
            sleepSeconds(2);
        }

        Assert.assertFalse(driver.findElement(chinhSanhCheckbox).isSelected());
    }

    @Test
    public void TC_05_Default_Nopcommerce_Checkbox() {
        driver.get("https://demo.nopcommerce.com/register");
        By newsletterCheckbox = By.xpath("//input[@id='Newsletter']");
        if (driver.findElement(newsletterCheckbox).isSelected()) {
            driver.findElement(newsletterCheckbox).click();
        }
        Assert.assertFalse(driver.findElement(newsletterCheckbox).isSelected());

    }

    @Test
    public void TC_06_Default_Telerik_Radio() {
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        By twoPetrolRadio = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");
        By twoDieselRadio= By.xpath("//label[text()='2.0 Diesel, 103kW']/preceding-sibling::span/input");

        checkToElement(twoPetrolRadio);
        Assert.assertTrue(driver.findElement(twoPetrolRadio).isSelected());
        Assert.assertFalse(driver.findElement(twoDieselRadio).isSelected());
        checkToElement(twoDieselRadio);
        Assert.assertFalse(driver.findElement(twoPetrolRadio).isSelected());
        Assert.assertTrue(driver.findElement(twoDieselRadio).isSelected());
    }
    @Test
    public void TC_07_Default_Nopcommerce_Radio() {
        driver.get("https://demo.nopcommerce.com/register");
        By maleRadio = By.xpath("//label[text()='Male']/preceding-sibling::input");
        By femaleRadio= By.xpath("//label[text()='Female']/preceding-sibling::input");

        checkToElement(maleRadio);
        Assert.assertTrue(driver.findElement(maleRadio).isSelected());
        Assert.assertFalse(driver.findElement(femaleRadio).isSelected());

        checkToElement(femaleRadio);
        Assert.assertFalse(driver.findElement(maleRadio).isSelected());
        Assert.assertTrue(driver.findElement(femaleRadio).isSelected());
    }
    @Test
    public void TC_08_Select_All_Checkbox(){
        driver.get("https://automationfc.github.io/multiple-fields/");
         List <WebElement> allCheckbox = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox'"));
         for(WebElement checkbox:allCheckbox){
             if(!checkbox.isSelected()){
                 checkbox.click();
                 sleepSeconds(2);
             }
         }
         for (WebElement checkbox:allCheckbox){
             Assert.assertTrue(checkbox.isSelected());
         }
         driver.manage().deleteAllCookies();
         driver.navigate().refresh();
        allCheckbox = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox'"));
         for (WebElement checkbox:allCheckbox){
             if(checkbox.getAttribute("value").equals("Heart Attack") && !checkbox.isSelected()){
                 checkbox.click();
                 sleepSeconds(1);
             }
         }
         for(WebElement checkbox:allCheckbox){
             if(checkbox.getAttribute("value").equals("Heart Attack")){
                 Assert.assertTrue(checkbox.isSelected());
             }else {
                 Assert.assertFalse(checkbox.isSelected());
             }

         }
    }
   // @Test page is not work
    public void TC_10_Custom_Radio(){
        driver.get("https://tiemchungcovid19.moh.gov.vn/portal/register-person");
        By registerRadio = By.xpath("//div[text()='Đăng ký cho người thân']/preceding-sibling::div/input");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(registerRadio));
        sleepSeconds(2);
        Assert.assertTrue(driver.findElement(registerRadio).isSelected());

    }
    @Test
    public void TC_11_Ubuntu_Custom_Radio_Checkbox(){
        driver.get("https://login.ubuntu.com/");
        By disagressRadio = By.xpath("//input[@id='id_new_user']");
        By agressCheckbox = By.xpath("//input[@id='id_accept_tos']");
        By agressLabel = By.xpath("//label[text()='I have read and accept the ']");

        Assert.assertFalse(driver.findElement(disagressRadio).isSelected());
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(disagressRadio));
        sleepSeconds(1);
        Assert.assertTrue(driver.findElement(disagressRadio).isSelected());

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(agressLabel));
        sleepSeconds(1);


        Assert.assertFalse(driver.findElement(agressCheckbox).isSelected());
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(agressCheckbox));
        sleepSeconds(1);
        Assert.assertTrue(driver.findElement(agressCheckbox).isSelected());


    }
    @Test
    public void TC_12_Google_Custom_Radio(){
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        By canThoRadio = By.xpath("//div[@aria-label='Cần Thơ']");
        By quangBinhcheckbox = By.xpath("//div[@aria-label='Quảng Bình']");
        Assert.assertEquals(driver.findElement(canThoRadio).getAttribute("aria-checked"), "false");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ' and @aria-checked='false']")).isDisplayed());

        driver.findElement(canThoRadio).click();
        sleepSeconds(1);
        Assert.assertEquals(driver.findElement(canThoRadio).getAttribute("aria-checked"), "true");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ' and @aria-checked='true']")).isDisplayed());

        driver.findElement(quangBinhcheckbox).click();
        sleepSeconds(1);
        Assert.assertEquals(driver.findElement(canThoRadio).getAttribute("aria-checked"), "true");


    }


    @Test
    public void TC_09_Spincast_Select_All_checkbox(){
        driver.get("https://www.spincast.org/demos-tutorials/html-forms/multiple-fields");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(By.xpath("//label[text()='Pick 2 numbers *']"));
        js.executeScript("arguments[0].scrollIntoView();", Element);

        List <WebElement> allCheckbox = driver.findElements(By.cssSelector("div.col-sm-4 div.checkbox input"));
        for(WebElement checkbox:allCheckbox){
            if(!checkbox.isSelected()){
                checkbox.click();
                sleepSeconds(1);
            }
        }
        for(WebElement checkbox:allCheckbox){
            Assert.assertTrue(checkbox.isSelected());
        }
        driver.navigate().refresh();
        allCheckbox = driver.findElements(By.cssSelector("div.col-sm-4 div.checkbox input"));
        for(WebElement checkbox:allCheckbox){
            if(checkbox.getAttribute("value").equals("2") && !checkbox.isSelected()){
                checkbox.click();
            }
        }
        for(WebElement checkbox:allCheckbox){
            if(checkbox.getAttribute("value").equals("2")){
                Assert.assertTrue(checkbox.isSelected());
            }else {
                Assert.assertFalse(checkbox.isSelected());
            }
        }

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepSeconds(long timeInsecond) {
        try {
            Thread.sleep(timeInsecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void checkToElement(By byXpath) {
        if (!driver.findElement(byXpath).isSelected()) {
            driver.findElement(byXpath).click();
            sleepSeconds(2);
        }
    }

    public void uncheckToElement(By byXpath) {
        if (driver.findElement(byXpath).isSelected()) {
            driver.findElement(byXpath).click();
            sleepSeconds(2);
        }
    }
}
