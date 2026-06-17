/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
public class Enrollment {
    private int enrollmentID;
    private Date enrollDate;
    private String enrollStatus;
    
    public int getEnrollmentID() { 
        return enrollmentID;
    }
    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID; 
    }

    public Date getEnrollDate() { 
        return enrollDate; 
    }
    public void setEnrollDate(Date enrollDate) { 
        this.enrollDate = enrollDate; 
    }

    public void setEnrollStatus(String enrollStatus) { 
        this.enrollStatus = enrollStatus; 
    }
    
    public String getStatus() { 
        return this.enrollStatus; 
    }
    
}
