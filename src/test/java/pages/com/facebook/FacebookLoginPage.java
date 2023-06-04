package pages.com.facebook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import utilities.BasePage;

public class FacebookLoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='email']")
    public WebElement usernameEntryField;

    @FindBy(xpath = "//input[@id='pass']")
    public WebElement passwordEntryField;

    @FindBy(xpath = "//button[@data-testid='royal_login_button']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[text()='Find your account and log in.']")
    public WebElement failedLoginMessage;


}
