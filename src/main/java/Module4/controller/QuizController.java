/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.Quiz;
import entity.Question;
import java.io.*;
import java.util.ArrayList;

public class QuizController {
    
    public boolean createQuiz(String quizId, String title, String subjectCode) {
        if (quizId.isEmpty() || title.isEmpty() || subjectCode.isEmpty()) return false;
        
        Quiz newQuiz = new Quiz(quizId, title, subjectCode);
        
        try (FileWriter fw = new FileWriter("Quizzes.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(newQuiz.getQuizId() + "," + newQuiz.getTitle() + "," + newQuiz.getSubjectCode());
            return true;
        } catch (IOException e) {
            return false;
        }
    }
  
    
    public boolean addQuestionToQuiz(String quizId, String questionText, String optionA, String optionB, String optionC, String optionD, String correctAns) {
        if (questionText.isEmpty() || correctAns.isEmpty()) { 
        return false;
    }

    try (java.io.FileWriter fw = new java.io.FileWriter("Questions.txt", true);
         java.io.PrintWriter pw = new java.io.PrintWriter(fw)) {

        pw.println(quizId + "|" + questionText + "|" + optionA + "|" + optionB + "|" + optionC + "|" + optionD + "|" + correctAns);
        return true;
    } catch (java.io.IOException e) {
        e.printStackTrace();
        return false;
    }
    }
    
    public ArrayList<Question> getQuestionsForQuiz(String targetQuizId) {
        ArrayList<Question> quizQuestions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Questions.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length >= 7 && data[0].equals(targetQuizId)) {
                    quizQuestions.add(new Question(data[0], data[1], data[2], data[3], data[4], data[5], data[6]));
                }
            }
        } catch (IOException e) { /* Fail belum wujud */ }
        return quizQuestions;
    }
    
}

        
