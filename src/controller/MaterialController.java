package controller;

import database.DBConnection;
import entity.Material;
import java.sql.*;
import java.util.ArrayList;

public class MaterialController {

    public boolean addMaterial(

            int subjectId,
            String title,
            String description,
            String filePath) {

        String sql =
                "INSERT INTO materials "
                + "(subject_id,"
                + "title,"
                + "description,"
                + "file_path)"
                + " VALUES(?,?,?,?)";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, subjectId);
            pst.setString(2, title);
            pst.setString(3, description);
            pst.setString(4, filePath);

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Material> getAllMaterials() {

    ArrayList<Material> list =
            new ArrayList<>();

    String sql =
            "SELECT * FROM materials";

    try {

        Connection conn =
                DBConnection.getConnection();

        Statement st =
                conn.createStatement();

        ResultSet rs =
                st.executeQuery(sql);

        while(rs.next()){

            Material material =
                    new Material(

                            rs.getInt(
                                    "material_id"),

                            rs.getString(
                                    "title"),

                            rs.getString(
                                    "description"),

                            rs.getString(
                                    "file_path")
                    );

            list.add(material);
        }

    } catch (SQLException e) {

        e.printStackTrace();
    }

    return list;
}
    public ArrayList<String> getAllSubjects() {

    ArrayList<String> subjects =
            new ArrayList<>();

    String sql =
            "SELECT subject_name FROM subjects";

    try {

        Connection conn =
                DBConnection.getConnection();

        Statement st =
                conn.createStatement();

        ResultSet rs =
                st.executeQuery(sql);

        while (rs.next()) {

            subjects.add(
                    rs.getString("subject_name"));
        }

    } catch (Exception e) {

        e.printStackTrace();
    }

    return subjects;
}
    
    public boolean deleteMaterial(
        int materialId){

    String sql =
            "DELETE FROM materials "
            + "WHERE material_id=?";

    try{

        Connection conn =
                DBConnection.getConnection();

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setInt(1, materialId);

        return pst.executeUpdate() > 0;

    }catch(Exception e){

        e.printStackTrace();
    }

    return false;
}
}