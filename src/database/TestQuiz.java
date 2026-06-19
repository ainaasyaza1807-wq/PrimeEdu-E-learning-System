package database;

import controller.QuizController;

public class TestQuiz {

    public static void main(String[] args) {

        QuizController controller =
                new QuizController();

        boolean result =
                controller.addQuiz(

                        "Q001",
                        "Java Quiz",
                        "MAT101"
                );

        System.out.println(result);
    }
}