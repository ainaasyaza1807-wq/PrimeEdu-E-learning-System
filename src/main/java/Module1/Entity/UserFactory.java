package Module1.Entity;

public class UserFactory {

public static User createUser(
        String role,
        String fullName,
        String email,
        String phoneNumber,
        String password) {

    if (role.equalsIgnoreCase("Parent")) {

        return new Parent(
                fullName,
                email,
                phoneNumber,
                password,
                role);

    } else {

        return new Student(
                fullName,
                email,
                phoneNumber,
                password,
                role,
                "",
                "");
    }
}
}
