package page;

import decorator.WebDriverDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends WebDriverDecorator {
    protected static final int TIMEOUT = 10;

    public BasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
