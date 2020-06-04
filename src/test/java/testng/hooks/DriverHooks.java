package testng.hooks;


import driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import page.BasePage;


public class DriverHooks {


    @Before
    public void setupDriver() {
        DriverSingleton.getDriver();
    }

    @After
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
