package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GmailAccountPage;
import page.GmailHomePage;
import sevice.UserCreator;

public class GmailReplyTest extends BaseTest {

    private User testUser = UserCreator.withCredentialsFromProperty();
//    private WebDriver driver;

    @Test
    public void replyTheMail() {
        String address = "sh.tonoyan@ysu.am";
        String subject = "My mail";
        String messageContent = "Text";
        GmailHomePage gmailHomePage = new GmailHomePage(driver);
        gmailHomePage.open();
        GmailAccountPage gmailAccountPage = gmailHomePage.fillLoginField(testUser.getUsername()).fillPasswordField(testUser.getPassword());

        Assert.assertTrue(gmailAccountPage.isLoginSuccessfull(), "Not successfull login");

        gmailAccountPage.openSearchOptions().fillSearchOptionFrom(address).fillSearchOptionSubject(subject).search();
        gmailAccountPage.openMailFromAddress(address).reply().writeMessage(messageContent).sendMail();

        Assert.assertTrue(gmailAccountPage.openSentMails().isMailInSentMails(subject));

        Assert.assertTrue(gmailAccountPage.clickGoogleAccount().logout().isLogoutSuccessfull());
    }

}
