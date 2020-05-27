package test;

import mailfactory.Email;
import mailfactory.EmailCreator;
import mailfactory.WithAttachmentEmailCreator;
import mailfactory.WithContentEmailCreator;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GmailAccountPage;
import page.GmailHomePage;
import sevice.UserCreator;

public class GmailSendMailWithAttachmentTest extends BaseTest {
    private User testUser = UserCreator.withCredentialsFromProperty();

    @Test
    public void sendMailWithAttachment() {
        EmailCreator creator = new WithAttachmentEmailCreator();
        Email email = creator.getEmail();

        GmailHomePage gmailHomePage = new GmailHomePage(driver);
        gmailHomePage.open();
        GmailAccountPage gmailAccountPage = gmailHomePage.fillLoginField(testUser.getUsername()).fillPasswordField(testUser.getPassword());

        Assert.assertTrue(gmailAccountPage.isLoginSuccessfull(), "Not successfull login");

        gmailAccountPage
                .composeNewMail()
                .fillAddress(email.getRecipient())
                .fillTitle(email.getTitle())
                .writeMessage(email.getContent())
                .boldTheMailContent()
                .attachFile(email.getAttachment())
                .sendMail();

        Assert.assertTrue(gmailAccountPage.openSentMails().isMailInSentMails(email.getTitle()));

        Assert.assertTrue(gmailAccountPage.clickGoogleAccount().logout().isLogoutSuccessfull());
    }
}
