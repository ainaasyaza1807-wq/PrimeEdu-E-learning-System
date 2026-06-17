/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FeedbackController {
    
    public boolean sendFeedback(String feedbackId, String studentId, String teacherId, String comments) {
        if (comments.isEmpty()) return false;

        try (FileWriter fw = new FileWriter("Feedbacks.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(feedbackId + "," + studentId + "," + teacherId + "," + comments);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
}
