package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GmailAccountPage;
import page.GmailHomePage;
import sevice.UserCreator;

public class GmailStarrMailsTest extends BaseTest {
    private User testUser = UserCreator.withCredentialsFromProperty();
//    private WebDriver driver;

    @Test
    public void addMailsToStarred() {
        String address = "sh.tonoyan@gmail.com";

        GmailHomePage gmailHomePage = new GmailHomePage(driver);
        gmailHomePage.open();
        GmailAccountPage gmailAccountPage = gmailHomePage.fillLoginField(testUser.getUsername()).fillPasswordField(testUser.getPassword());

        Assert.assertTrue(gmailAccountPage.isLoginSuccessfull(), "Not successfull login");

        gmailAccountPage.openSearchOptions().fillSearchOptionFrom(address).search();
        gmailAccountPage.starrMails();
        gmailAccountPage.openStarredMails()
                .areMailsFromSenderStarred(address).forEach(Assert::assertTrue);
        gmailAccountPage.unstarrMailsFromSender(address);
        Assert.assertTrue(gmailAccountPage.areMailsFromSenderUnstarred(address));

        Assert.assertTrue(gmailAccountPage.clickGoogleAccount().logout().isLogoutSuccessfull());
    }

}
