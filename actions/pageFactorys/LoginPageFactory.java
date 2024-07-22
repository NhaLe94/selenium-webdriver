package pageFactorys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPageFactory extends BasePage {
    private WebDriver driver;
    public LoginPageFactory(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordTextbox;

    @FindBy(xpath = "//button[contains(@class,'login-button')]")
    private WebElement loginButton;


    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver,emailTextbox);
        sendkeyToElement(emailTextbox, email);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, passwordTextbox);
        sendkeyToElement(passwordTextbox, password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, loginButton);
        clickToElement(loginButton);
    }
}
