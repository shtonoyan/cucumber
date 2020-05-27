package mailfactory;

import sevice.TestDataReader;

public class Email {
    private String recipient;
    private String title;
    private String content;
    private String attachment;

    public Email() {
        this.recipient = TestDataReader.getTestData("email.recipient");
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
