/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


public class Assessment {
    
    private String assessmentId;
    private String title;
    private String description;
    private String instructorId;
    private java.util.Date dueDate;
    private int score;
    private String teacherComment;  
    
    public Assessment() {
    }
    
    public Assessment(String assessmentId, String title, String description) {
        this.assessmentId = assessmentId;
        this.title = title;
        this.description = description;
    }
    
    public String getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getInstructorId() { 
        return instructorId; 
    }
    public void setInstructorId(String instructorId) {
    this.instructorId = instructorId; 
    }
    
    public java.util.Date getDueDate() { 
        return dueDate; 
    }
    public void setDueDate(java.util.Date dueDate) { 
        this.dueDate = dueDate; 
    }
    
    public int getScore() { 
        return score; 
    }
    public void setScore(int score) { 
        this.score = score; 
    }

    public String getTeacherComment() { 
        return teacherComment; 
    }
    public void setTeacherComment(String teacherComment) { 
        this.teacherComment = teacherComment; 
    }
}
    



