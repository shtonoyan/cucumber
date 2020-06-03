package page;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    private static WebDriver driver = DriverSingleton.getDriver();

    public static GmailAccountPage getGmailAccountPage(){
        return new GmailAccountPage(driver);
    }
    public static GmailHomePage getGmailHomePage(){
        return new GmailHomePage(driver);
    }
}
