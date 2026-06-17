/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
public class Progress {
    
    private int progressID;
    private double percentage;
    private Date lastUpdate;
    
    public int getProgressID() { 
        return progressID; 
    }
    public void setProgressID(int progressID) {
        this.progressID = progressID; 
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage; 
    }
    public Date getLastUpdate() { 
        return lastUpdate;
    }
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate; 
    }
    
    public void updateProgress() { 
        System.out.println("Progress updated."); 
    }
    public double getProgress() { 
        return this.percentage; 
    }
    
}
