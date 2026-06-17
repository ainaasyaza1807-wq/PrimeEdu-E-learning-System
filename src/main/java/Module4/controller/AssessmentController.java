/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entity.Assessment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AssessmentController implements AssessmentOperations {
    
    private ArrayList<Assessment> assessments;
    
    public AssessmentController() {
        this.assessments = new ArrayList<>();
    }
    
    @Override
    public boolean createAssessment(String id, String title, String description, String instructorId) {
    // 1. Maklumat konfigurasi pangkalan data XAMPP (Port 3307)
    String url = "jdbc:mysql://localhost:3306/primeedu_db";
    String user = "root";
    String password = ""; // Default XAMPP sememangnya kosong/tiada password

    // 2. Arahan SQL bertanda '?' (PreparedStatement) untuk mengelakkan SQL Injection
    String sql = "INSERT INTO assessments (assessment_id, title, description, instructor_id) VALUES (?, ?, ?, ?)";

    // 3. Membuka sambungan dan menyediakan penyata SQL
    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        // 4. Memasukkan nilai pembolehubah ke dalam tanda '?' mengikut turutan colum
        pstmt.setString(1, id);
        pstmt.setString(2, title);
        pstmt.setString(3, description);
        pstmt.setString(4, instructorId);

        // 5. Menjalankan arahan SQL ke dalam MySQL XAMPP
        int rowsInserted = pstmt.executeUpdate();
        
        // Jika ada baris yang bertambah (rows > 0), maksudnya data selamat disimpan!
        if (rowsInserted > 0) {
            System.out.println("✅ DATABASE: Berjaya menyimpan tugasan baharu [" + id + "] ke MySQL!");
            return true;
        }
        
    } catch (SQLException e) {
        // Jika ada ralat (cth: database tak on, port salah, atau ID bertembung), ralat akan dipaparkan di sini
        System.out.println("❌ DATABASE ERROR: Gagal mencipta assessment.");
        System.out.println("Sebab Ralat: " + e.getMessage());
    }
    
    return false;
}

    
    @Override
    public java.util.ArrayList<entity.Assessment> getAllAssessments() {
        java.util.ArrayList<entity.Assessment> list = new java.util.ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/primeedu_db";
        String user = "root";
        String password = "";
        String sql = "SELECT * FROM assessments"; // 🌟 Pastikan nama table anda betul 'assessments'
        
        System.out.println("LOG: Memulakan sambungan ke Database untuk mengambil semua rekod...");
        
        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(url, user, password);
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
             java.sql.ResultSet rs = pstmt.executeQuery()) {
            
            int count = 0;
            while (rs.next()) {
                count++;
                entity.Assessment ass = new entity.Assessment();
                ass.setAssessmentId(rs.getString("assessment_id"));
                ass.setTitle(rs.getString("title"));
                ass.setDescription(rs.getString("description"));
                ass.setInstructorId(rs.getString("instructor_id"));
                ass.setScore(rs.getInt("score"));
                
                list.add(ass);
            }
            
            System.out.println("LOG: Berjaya membaca data! Jumlah rekod dijumpai di DB: " + count);
            
        } catch (java.sql.SQLException e) {
            System.out.println("LOG ERROR: Gagal membaca database! Punca: " + e.getMessage());
        }
        
        return list;
    }
    
    @Override
    public Assessment getAssessmentById(String id) {
        String url = "jdbc:mysql://localhost:3306/primeedu_db";
        String user = "root";
        String password = "";
        
        // Query SQL biasa untuk mengambil satu baris rekod berdasarkan ID
        String sql = "SELECT * FROM assessments WHERE assessment_id = ?";
        
        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(url, user, password);
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, id);
            
            try (java.sql.ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Assessment ass = new Assessment();
                    ass.setAssessmentId(rs.getString("assessment_id"));
                    ass.setTitle(rs.getString("title"));
                    ass.setDescription(rs.getString("description"));
                    
                    // 🌟 KEMAS KINI DI SINI: Baca kolum baharu dari Database masuk ke entiti Java
                    ass.setScore(rs.getInt("score")); 
                    ass.setTeacherComment(rs.getString("teacher_comment"));
                    
                    // (Opsional) Ambil tarikh akhir jika ada kolum due_date di DB anda
                    // ass.setDueDate(rs.getDate("due_date")); 
                    
                    return ass;
                }
            }
        } catch (java.sql.SQLException e) {
            System.out.println("Error fetch assessment by ID: " + e.getMessage());
        }
        
        return null;
    }
    
    @Override
    public boolean updateAssessmentDescription(String id, String newDesc) {
        ArrayList<Assessment> list = getAllAssessments();
        boolean found = false;
        
        if (list != null && id != null) {
            for (Assessment ass : list) {
                if (id.equalsIgnoreCase(ass.getAssessmentId())) {
                    ass.setDescription(newDesc);
                    found = true;
                    break;
                }
            }
        }
        
        if (found) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Assessments.txt", false))) { 
                for (Assessment ass : list) {
                    writer.write(ass.getAssessmentId() + "," + ass.getTitle() + "," + ass.getDescription());
                    writer.newLine();
                }
                return true;
            } catch (IOException e) {
                System.out.println("ERROR: " + e.getMessage());
                return false;
            }
        }
        return false;
    }
    
    public boolean saveAssessmentGrade(String id, int score, String comment) {
    String url = "jdbc:mysql://localhost:3306/primeedu_db";
    String user = "root";
    String password = "";
    
    // Guna query UPDATE untuk memasukkan markah terus ke kolum spesifik
    String sql = "UPDATE assessments SET score = ?, teacher_comment = ? WHERE assessment_id = ?";
    
    try (java.sql.Connection conn = java.sql.DriverManager.getConnection(url, user, password);
         java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setInt(1, score);
        pstmt.setString(2, comment);
        pstmt.setString(3, id);
        
        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0; // Pulangkan true jika berjaya update
        
    } catch (java.sql.SQLException e) {
        System.out.println("Error saving grade: " + e.getMessage());
        return false;
    }
    }
}

