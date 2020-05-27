package mailfactory;

import sevice.TestDataReader;

public class WithContentEmailCreator implements EmailCreator {
    @Override
    public Email getEmail() {
        Email email = new Email();
        email.setTitle(TestDataReader.getTestData("email.title"));
        email.setContent(TestDataReader.getTestData("email.content"));

        return email;
    }
}
