package testng.hooks;


import driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import page.BasePage;


public class DriverHooks {
    protected WebDriver driver;

    @Before
    public void setupDriver() {
        driver = new BasePage(DriverSingleton.getDriver());
    }

    @After
    public void browserTearDown() {
        driver.quit();
    }
}
