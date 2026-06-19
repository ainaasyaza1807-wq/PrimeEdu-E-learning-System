package database;

import controller.ResultController;

public class TestResult {

    public static void main(String[] args) {

        ResultController controller =
                new ResultController();

        boolean result =
                controller.saveResult(

                        "Q001",
                        1,
                        80
                );

        System.out.println(result);
    }
}