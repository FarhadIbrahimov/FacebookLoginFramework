package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    public static WebDriver driver;

    private Driver(){}

    public static WebDriver getDriver(){
        if(driver == null){
            switch (PropertiesReader.CONFIGURATIONS.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();

                    if(PropertiesReader.CONFIGURATIONS.getProperty("localDocker").equals("true")) {
                        options.addArguments("--ignore-certificate-errors");
                        options.addArguments("--allow-running-insecure-content");
                    }

                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                    break;
                case "firefox":
                   WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

                    break;
                    }
            }
        return driver;
        }
        public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
