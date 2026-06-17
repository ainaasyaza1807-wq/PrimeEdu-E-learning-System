/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


public class Parent {
    private int parentID;
    
    public int getParentID() { 
        return parentID; 
    }
    public void setParentID(int parentID) { 
        this.parentID = parentID; 
    }
 
    public void viewResults(int subjectID) { 
        System.out.println("Parent viewing subject: " + subjectID); 
    }
    public void provideFeedback(int targetID) { 
        System.out.println("Parent feedback for: " + targetID); 
    }
}
