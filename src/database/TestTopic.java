package database;

import controller.TopicController;

public class TestTopic {

    public static void main(String[] args) {

        TopicController controller =
                new TopicController();

        boolean result =
                controller.addTopic(
                        1,
                        "Introduction to Java"
                );

        System.out.println(result);
    }
}