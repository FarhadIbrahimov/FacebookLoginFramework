package stepDefinitions.com.facebook;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.com.facebook.FacebookLoginPage;
import utilities.Driver;
import utilities.PropertiesReader;

public class FacebookTestSteps {


    static WebDriver driver = Driver.getDriver();
    FacebookLoginPage facebookLoginPage = new FacebookLoginPage();


    @Given("user navigates to Facebook webpage")
    public void user_navigates_to_facebook_webpage() {
        driver.navigate().to(PropertiesReader.URL.getProperty("facebook"));
    }
    @When("user enters {string} in the username box")
    public void user_enters_in_the_username_box(String string) {
       facebookLoginPage.usernameEntryField.sendKeys(string);
    }
    @And("user enters {string} in the password box")
    public void user_enters_in_the_password_box(String string1) {
        facebookLoginPage.passwordEntryField.sendKeys(string1);
    }
    @And("user clicks on login button")
    public void user_clicks_on_login_button() {
        facebookLoginPage.loginButton.click();
    }
    @Then("user unable to login and receives an error message containing {string}")
    public void user_unable_to_login_and_receives_an_error_message_containing(String str) {

        Assert.assertEquals(str,facebookLoginPage.failedLoginMessage.getText());
    }

}
