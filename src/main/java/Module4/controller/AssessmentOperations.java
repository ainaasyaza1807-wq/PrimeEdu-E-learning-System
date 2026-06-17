/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.Assessment;
import java.util.ArrayList;

public interface AssessmentOperations {
    ArrayList<Assessment> getAllAssessments();
    Assessment getAssessmentById(String id);
    boolean updateAssessmentDescription(String id, String newDesc);
    boolean createAssessment(String id, String title, String description, String instructorId);
}
