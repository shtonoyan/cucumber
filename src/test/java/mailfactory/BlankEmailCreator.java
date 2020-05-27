package mailfactory;

public class BlankEmailCreator implements EmailCreator {
    @Override
    public Email getEmail() {
        return new Email();
    }
}
