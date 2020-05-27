package test;

import decorator.WebDriverDecorator;
import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import page.BasePage;
import utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {
    protected BasePage driver;

    @BeforeMethod
    public void browserSetup(){
        driver = new BasePage(DriverSingleton.getDriver());

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
    }

}
