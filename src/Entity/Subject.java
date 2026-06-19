package entity;

import java.util.ArrayList;

public class Subject {

    private int subjectId;
    private String subjectName;
    private Instructor instructor;
    private String standard;
    private String subjectCode;

    private ArrayList<Material> materials;

    public Subject(
        int subjectId,
        String standard,
        String subjectCode,
        String subjectName,
        Instructor instructor) {

    this.subjectId = subjectId;
    this.standard = standard;
    this.subjectCode = subjectCode;
    this.subjectName = subjectName;
    this.instructor = instructor;

    materials = new ArrayList<>();
    }

    public Subject(
            int subjectId,
            String subjectName,
            Instructor instructor) {

        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.instructor = instructor;

        materials =
                new ArrayList<>();
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(
            int subjectId) {

        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(
            String subjectName) {

        this.subjectName = subjectName;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(
            Instructor instructor) {

        this.instructor = instructor;
    }

    public ArrayList<Material>
    getMaterials() {

        return materials;
    }

    public void addMaterial(
            Material material) {

        materials.add(material);
    }

    public void removeMaterial(
            Material material) {

        materials.remove(material);
    }

    @Override
    public String toString() {

        return subjectName;
    }
}