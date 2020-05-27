package mailfactory;

public class BlankEmailCreator implements EmailCreator {
    @Override
    public Email getEmail() {
        Email email = new Email();
        email.setTitle();
        return email;
    }
}
