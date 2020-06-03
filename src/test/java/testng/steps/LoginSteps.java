package testng.steps;

import driver.DriverSingleton;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.BasePage;
import page.GmailAccountPage;
import page.GmailHomePage;
import page.PageFactory;
//import testng.hooks.DriverHooks;

public class LoginSteps  {


    private GmailHomePage gmailHomePage = PageFactory.getGmailHomePage();
    private GmailAccountPage gmailAccountPage = PageFactory.getGmailAccountPage();

    @Given("the user opens the gmail website")
    public void opensGmailWebsite() {
        gmailHomePage.open();
    }
    @When("the user type the username {string}")
    public void theUserTypeTheUsername(String username) {
        gmailHomePage.fillLoginField(username);
    }

    @When("click the next button")
    public void clickTheNextButton() {
        gmailHomePage.clickNextBtn();
    }

    @When("the user type password {string}")
    public void typePasswordAndClickTheNextButton(String password) {
        gmailHomePage.fillPasswordField(password);

    }

    @Then("gmail inbox page is displayed")
    public void gmailInboxPageIsDisplayed() {
        Assert.assertTrue(gmailAccountPage.isLoginSuccessfull());
    }

}
