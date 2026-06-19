package database;

import controller.QuestionController;

public class TestQuestion {

    public static void main(String[] args) {

        QuestionController controller =
                new QuestionController();

        boolean result =
                controller.addQuestion(

                        "Q001",
                        "What is Java?",
                        "Programming Language",
                        "Database",
                        "Browser",
                        "Operating System",
                        "A"
                );

        System.out.println(result);
    }
}