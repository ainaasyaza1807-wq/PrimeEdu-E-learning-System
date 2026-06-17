/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module2.entity;

public class Subject {
    private String code;
    private String name;
    private String standard;
    private String teacherName; // NEW!

    public Subject(String code, String name, String standard, String teacherName) {
        this.code = code;
        this.name = name;
        this.standard = standard;
        this.teacherName = teacherName;
    }

    // Getters
    public String getCode() { return code; }
    public String getName() { return name; }
    public String getStandard() { return standard; }
    public String getTeacherName() { return teacherName; } // NEW!

    // Setters for Editing
    public void setName(String name) { this.name = name; }
    public void setStandard(String standard) { this.standard = standard; }
    public void setTeacherName(String teacherName) { this.teacherName = teacherName; } // NEW!
}