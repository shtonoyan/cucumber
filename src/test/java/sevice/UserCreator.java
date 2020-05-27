package sevice;

import model.User;

public class UserCreator {
    public static final String USER_NAME = "testdata.user.name";
    public static final String PASSWORD = "testdata.password";

    public static User withCredentialsFromProperty() {
        return new User(TestDataReader.getTestData(USER_NAME),TestDataReader.getTestData(PASSWORD));
    }

    public static User withEmptyUsername() {
        return new User("", PASSWORD);
    }

    public static User withEmptyPassword() {
        return new User(USER_NAME, "");
    }
}
