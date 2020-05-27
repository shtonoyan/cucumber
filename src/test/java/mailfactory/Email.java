package mailfactory;

import model.User;
import sevice.TestDataReader;

public class Email {
    private String recipient;
    private String title;
    private String content;
    private String attachment;
//    public static final String RECIPIENT = "email.recipient";
//    public static final String TITLE="email.title";
//    public static final String CONTENT="email.content";
//    public static final String ATTACHMENT="email.attachment";

    public Email() {
        this.recipient=TestDataReader.getTestData("email.recipient");
    }

    public String getRecipient() {
        return recipient;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setTitle() {
        this.title = TestDataReader.getTestData("email.title");
    }

    public void setContent() {
        this.content = TestDataReader.getTestData("email.content");
    }

    public void setAttachment() {
        this.attachment = TestDataReader.getTestData("email.attachment");
    }
}
