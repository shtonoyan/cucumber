package mailfactory;

import sevice.TestDataReader;

public class WithAttachmentEmailCreator implements EmailCreator {
    @Override
    public Email getEmail() {
        Email email = new Email();
        email.setTitle(TestDataReader.getTestData("email.title"));
        email.setContent(TestDataReader.getTestData("email.content"));
        email.setAttachment(TestDataReader.getTestData("email.attachment"));
        return email;
    }
}
