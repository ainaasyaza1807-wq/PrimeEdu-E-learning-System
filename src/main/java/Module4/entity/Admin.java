/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author user
 */
public class Admin extends User{
    private int adminID;
    
    public int getAdminID() { 
        return adminID; 
    }
    public void setAdminID(int adminID) { 
        this.adminID = adminID; 
    }
    
    public void manageRecords() { 
        System.out.println("Managing system records."); 
    }
    public void editRecord(int recordID) { 
        System.out.println("Editing record: " + recordID); 
    }
    public void deleteRecord(int recordID) { 
        System.out.println("Deleting record: " + recordID); 
    }
    public void archiveRecord(int recordID) { 
        System.out.println("Archiving record: " + recordID); 
    }
}

