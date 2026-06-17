/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
public class Feedback {
    private int feedbackID;
    private String feedbackText;
    private String feedbackBy;
    private Date feedbackDate;
    
    public int getFeedbackID() { 
        return feedbackID; 
    }
    public void setFeedbackID(int feedbackID) { 
        this.feedbackID = feedbackID; 
    }

    public String getFeedbackText() { 
        return feedbackText; 
    }
    public void setFeedbackText(String feedbackText) { 
        this.feedbackText = feedbackText; 
    }

    public String getFeedbackBy() { 
        return feedbackBy; 
    }
    public void setFeedbackBy(String feedbackBy) { 
        this.feedbackBy = feedbackBy; 
    }

    public Date getFeedbackDate() { 
        return feedbackDate;
    }
    public void setFeedbackDate(Date feedbackDate) { 
        this.feedbackDate = feedbackDate; 
    }
    
    public void submit() { 
        System.out.println("Feedback submitted successfully."); 
    }
    public boolean validate() {
        return feedbackText != null && !feedbackText.trim().isEmpty();
    }
    
}
