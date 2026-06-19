package module_2;

import controller.MaterialController;
import entity.Material;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class ManageMaterialsUI extends JFrame {

    private JTable tblMaterials;
    private DefaultTableModel model;

    private JButton btnOpen;
    private JButton btnDelete;
    private JButton btnClose;

    public ManageMaterialsUI() {

        setTitle("Manage Materials");

        setSize(900,600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        initializeUI();

        loadMaterials();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel =
                new JPanel(null);

        JLabel lblTitle =
                new JLabel(
                        "Materials for this Subject");

        lblTitle.setBounds(
                50,
                100,
                180,
                25);

        panel.add(lblTitle);

        model =
                new DefaultTableModel();

        model.addColumn("Material ID");
        model.addColumn("Title");
        model.addColumn("Description");
        model.addColumn("File Path");

        tblMaterials =
                new JTable(model);

        JScrollPane scrollPane =
                new JScrollPane(
                        tblMaterials);

        scrollPane.setBounds(
                200,
                90,
                450,
                300);

        panel.add(scrollPane);

        btnOpen =
                new JButton(
                        "Open File");

        btnOpen.setBounds(
                700,
                220,
                120,
                35);

        panel.add(btnOpen);

        btnDelete =
                new JButton(
                        "Delete Material");

        btnDelete.setBounds(
                700,
                270,
                120,
                35);

        panel.add(btnDelete);

        btnClose =
                new JButton(
                        "< Close");

        btnClose.setBounds(
                700,
                320,
                120,
                35);

        panel.add(btnClose);

        add(panel);

        btnOpen.addActionListener(
                e -> openFile());

        btnDelete.addActionListener(
                e -> deleteMaterial());

        btnClose.addActionListener(
                e -> dispose());
    }

    private void loadMaterials() {

        model.setRowCount(0);

        MaterialController controller =
                new MaterialController();

        ArrayList<Material> list =
                controller.getAllMaterials();

        for(Material material : list){

            model.addRow(new Object[]{

                    material.getId(),
                    material.getTitle(),
                    material.getDescription(),
                    material.getFilePath()
            });
        }
    }

    private void openFile() {

        int row =
                tblMaterials.getSelectedRow();

        if(row == -1){

            JOptionPane.showMessageDialog(
                    this,
                    "Select a material first");

            return;
        }

        String path =
                model.getValueAt(
                        row,
                        3).toString();

        try {

            Desktop.getDesktop().open(
                    new File(path));

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Unable to open file");
        }
    }

    private void deleteMaterial() {

        int row =
                tblMaterials.getSelectedRow();

        if(row == -1){

            JOptionPane.showMessageDialog(
                    this,
                    "Select a material first");

            return;
        }

        int materialId =
                Integer.parseInt(

                        model.getValueAt(
                                row,
                                0).toString());

        MaterialController controller =
                new MaterialController();

        boolean success =
                controller.deleteMaterial(
                        materialId);

        if(success){

            JOptionPane.showMessageDialog(
                    this,
                    "Material Deleted");

            loadMaterials();

        }else{

            JOptionPane.showMessageDialog(
                    this,
                    "Delete Failed");
        }
    }
}