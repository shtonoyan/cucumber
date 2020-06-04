package page;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

public class PageFactory {

    public static GmailAccountPage getGmailAccountPage(){
        return new GmailAccountPage(DriverSingleton.getDriver());
    }
    public static GmailHomePage getGmailHomePage(){
        return new GmailHomePage(DriverSingleton.getDriver());
    }
}
