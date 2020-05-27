package test;

import mailfactory.Email;
import mailfactory.EmailCreator;
import mailfactory.WithContentEmailCreator;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GmailAccountPage;
import page.GmailHomePage;
import sevice.UserCreator;

public class GmailDraftTest extends BaseTest {
    private User testUser = UserCreator.withCredentialsFromProperty();
//    private WebDriver driver;

    @Test
    public void createDraftSendIt() {
        GmailHomePage gmailHomePage = new GmailHomePage(driver);
        gmailHomePage.open();
        GmailAccountPage gmailAccountPage = gmailHomePage
                .fillLoginField(testUser.getUsername()).fillPasswordField(testUser.getPassword());

        Assert.assertTrue(gmailAccountPage.isLoginSuccessfull(), "Not successfull login");

        EmailCreator creator = new WithContentEmailCreator();
        Email email = creator.getEmail();

        gmailAccountPage
                .composeNewMail()
                .fillAddress(email.getRecipient())
                .fillTitle(email.getTitle())
                .writeMessage(email.getContent())
                .saveAsDraft();

        Assert.assertTrue(gmailAccountPage.openDrafts().isNewDraftSaved(email.getTitle()));

        gmailAccountPage.openDraftMail(email.getTitle());

        gmailAccountPage.sendMail();

        Assert.assertTrue(gmailAccountPage.openSentMails().isMailInSentMails(email.getTitle()));
    }

}
