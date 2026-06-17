/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
public class Result {
    private int resultID;
    private double marksObtained;
    private int maxMarks;
    private double percentage;
    private String comment;
    private Date gradedDate;
    
    public int getResultID() { 
        return resultID; 
    }
    public void setResultID(int resultID) { 
        this.resultID = resultID; 
    }

    public double getMarksObtained() { 
        return marksObtained; 
    }
    public void setMarksObtained(double marksObtained) { 
        this.marksObtained = marksObtained;
    }

    public int getMaxMarks() { 
        return maxMarks;
    }
    public void setMaxMarks(int maxMarks) { 
        this.maxMarks = maxMarks; 
    }

    public double getPercentage() { 
        return percentage; 
    }
    public void setPercentage(double percentage) { 
        this.percentage = percentage; 
    }

    public String getComment() { 
        return comment; 
    }
    public void setComment(String comment) { 
        this.comment = comment; 
    }

    public Date getGradedDate() { 
        return gradedDate; 
    }
    public void setGradedDate(Date gradedDate) { 
        this.gradedDate = gradedDate; 
    }
    
    public void calculatePercentage() {
        if (maxMarks > 0) {
            this.percentage = (this.marksObtained / this.maxMarks) * 100;
        }
    }
    public void displayResult() { 
        System.out.println("Marks obtained: " + marksObtained + " (" + percentage + "%)"); 
    }
}

