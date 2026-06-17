/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


public class Quiz {
    private String quizId;
    private String title;
    private String subjectCode;
    
    public Quiz(String quizId, String title, String subjectCode) {
        this.quizId = quizId;
        this.title = title;
        this.subjectCode = subjectCode;
    }
    
    public String getQuizId() { return quizId; }
    public String getTitle() { return title; }
    public String getSubjectCode() { return subjectCode; }
}
 

