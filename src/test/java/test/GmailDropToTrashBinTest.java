package test;

import model.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GmailAccountPage;
import page.GmailHomePage;
import sevice.UserCreator;

public class GmailDropToTrashBinTest extends BaseTest {
    private User testUser = UserCreator.withCredentialsFromProperty();
//    private WebDriver driver;

    @Test
    public void dropMailToTheTrashBin() {
        String title = "Second mail";

        GmailHomePage gmailHomePage = new GmailHomePage(driver);
        gmailHomePage.open();
        GmailAccountPage gmailAccountPage = gmailHomePage.fillLoginField(testUser.getUsername()).fillPasswordField(testUser.getPassword());

        Assert.assertTrue(gmailAccountPage.isLoginSuccessfull(), "Not successfull login");

        gmailAccountPage.dropMailToTrashBin(title);
        Assert.assertTrue(gmailAccountPage.openTrashBit().isMailInTrashBin(title));
    }

}
