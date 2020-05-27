package mailfactory;

public class WithContentEmailCreator implements EmailCreator {
    @Override
    public  Email getEmail() {
        Email email = new Email();
        email.setTitle();
        email.setContent();
        return email;
    }
}
