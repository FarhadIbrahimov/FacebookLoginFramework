package stepDefinitions.com.facebook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {


        WebDriver driver;

        @Before
        public void setUpDriver(){
            System.out.println("@Before Hook activated");
            driver = Driver.getDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        }

        @After
        public void tearDown(Scenario scenario){
            System.out.println("@After Hook activated");
            Driver.closeDriver();
            if(scenario.isFailed()){
                System.out.println("Test Failed");
            }
        }
    }