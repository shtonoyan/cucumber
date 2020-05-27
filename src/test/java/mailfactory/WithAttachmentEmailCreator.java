package mailfactory;

public class WithAttachmentEmailCreator implements EmailCreator {
    @Override
    public Email getEmail() {
        Email email = new Email();
        email.setTitle();
        email.setContent();
        email.setAttachment();
        return email;
    }
}
