package testng.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.GmailAccountPage;
import page.GmailHomePage;
import page.PageFactory;

public class MenuContent {
    private GmailHomePage gmailHomePage = PageFactory.getGmailHomePage();
    private GmailAccountPage gmailAccountPage = PageFactory.getGmailAccountPage();


    @When("user clicks on the {string} section")
    public void userClicksOnTheSection(String title) {
        gmailAccountPage.clickParticularMenuItem(title);
    }

    @Then("the title {string} is displayed")
    public void titleIsDisplayed(String title) {
        gmailAccountPage.isItemDisplayed(title);
    }
}
