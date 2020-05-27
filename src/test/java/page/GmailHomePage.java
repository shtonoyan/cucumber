package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GmailHomePage extends BasePage {
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(id = "logo")
    public WebElement logo;
    @FindBy(xpath = "//div[@class='lCoei YZVTmd SmR8']")
    private List<WebElement> accounts;

    public GmailHomePage(WebDriver driver) {
        super(driver);
    }

    public GmailHomePage open() {
        this.get("http://gmail.com");
        logger.info("Logged in to gmail");

        return this;
    }

    public GmailHomePage fillLoginField(String login) {
        WebElement loginField = new WebDriverWait(this, TIMEOUT)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.id("identifierId")));

        loginField.sendKeys(login);

        WebElement nextBtn = new WebDriverWait(this, TIMEOUT)
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//span[@class='RveJvd snByac']")));
        nextBtn.click();

        return this;
    }

    public GmailAccountPage fillPasswordField(String password) {

        new WebDriverWait(this, TIMEOUT)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//input[@type='password']")));
        WebElement passwordField = new WebDriverWait(this, TIMEOUT)
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//input[@type='password']")));
        passwordField.sendKeys(password);

        WebElement nextBtn = new WebDriverWait(this, TIMEOUT)
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//span[@class='RveJvd snByac']")));

        nextBtn = new WebDriverWait(this, TIMEOUT)
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//span[@class='RveJvd snByac']")));
        nextBtn.click();

        return new GmailAccountPage(this);
    }

    public boolean isLogoutSuccessfull() {
        new WebDriverWait(this, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(logo));
        return logo.isDisplayed();
    }
}
