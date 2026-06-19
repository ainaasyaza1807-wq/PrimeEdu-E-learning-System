package entity;

public class UserFactory {

    public static User createUser(
            String role,
            int userId,
            String username,
            String password,
            String fullName,
            String email) {

        switch (role.toUpperCase()) {

            case "ADMIN":
                return new Admin(
                        userId,
                        username,
                        password,
                        fullName,
                        email,
                        "SUPER ADMIN"
                );

            case "PARENT":
                return new Parent(
                        userId,
                        username,
                        password,
                        fullName,
                        email,
                        ""
                );

            case "STUDENT":
                return new Student(
                        userId,
                        username,
                        password,
                        fullName,
                        email,
                        ""
                );

            case "INSTRUCTOR":
                return new Instructor(
                        userId,
                        username,
                        password,
                        fullName,
                        email,
                        ""
                );

            default:
                return null;
        }
    }
}