package module_2;

import controller.MaterialController;

import javax.swing.*;
import java.awt.*;

public class UploadMaterialUI extends JFrame {

    private JComboBox<String> cmbSubject;

    private JTextField txtTitle;
    private JTextArea txtDescription;
    private JTextField txtFilePath;

    private JButton btnBrowse;
    private JButton btnUpload;
    private JButton btnBack;

    public UploadMaterialUI() {

        setTitle("Upload Material");

        setSize(900,600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        initializeUI();

        loadSubjects();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel =
                new JPanel(null);

        JLabel lblTitle =
                new JLabel(
                        "Upload Material");

        lblTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24));

        lblTitle.setBounds(
                330,
                40,
                250,
                30);

        panel.add(lblTitle);

        JLabel lblSubject =
                new JLabel(
                        "Subject:");

        lblSubject.setBounds(
                100,
                120,
                100,
                25);

        panel.add(lblSubject);

        cmbSubject =
                new JComboBox<>();

        cmbSubject.setBounds(
                220,
                120,
                250,
                30);

        panel.add(cmbSubject);

        JLabel lblMaterialTitle =
                new JLabel(
                        "Material Title:");

        lblMaterialTitle.setBounds(
                100,
                180,
                120,
                25);

        panel.add(lblMaterialTitle);

        txtTitle =
                new JTextField();

        txtTitle.setBounds(
                220,
                180,
                300,
                30);

        panel.add(txtTitle);

        JLabel lblDescription =
                new JLabel(
                        "Description:");

        lblDescription.setBounds(
                100,
                240,
                120,
                25);

        panel.add(lblDescription);

        txtDescription =
                new JTextArea();

        JScrollPane scrollPane =
                new JScrollPane(
                        txtDescription);

        scrollPane.setBounds(
                220,
                240,
                300,
                100);

        panel.add(scrollPane);

        JLabel lblFile =
                new JLabel(
                        "File:");

        lblFile.setBounds(
                100,
                370,
                120,
                25);

        panel.add(lblFile);

        txtFilePath =
                new JTextField();

        txtFilePath.setBounds(
                220,
                370,
                300,
                30);

        panel.add(txtFilePath);

        btnBrowse =
                new JButton(
                        "Browse");

        btnBrowse.setBounds(
                540,
                370,
                100,
                30);

        panel.add(btnBrowse);

        btnUpload =
                new JButton(
                        "Upload");

        btnUpload.setBounds(
                300,
                450,
                120,
                40);

        panel.add(btnUpload);

        btnBack =
                new JButton(
                        "< Back");

        btnBack.setBounds(
                450,
                450,
                120,
                40);

        panel.add(btnBack);

        add(panel);

        btnBrowse.addActionListener(
                e -> browseFile());

        btnUpload.addActionListener(
                e -> uploadMaterial());

        btnBack.addActionListener(
                e -> {

                    dispose();

                    // dashboard nanti
                });
    }

    private void browseFile() {

        JFileChooser chooser =
                new JFileChooser();

        int result =
                chooser.showOpenDialog(
                        this);

        if(result ==
                JFileChooser.APPROVE_OPTION){

            txtFilePath.setText(
                    chooser
                            .getSelectedFile()
                            .getAbsolutePath());
        }
    }

    private void uploadMaterial() {

        MaterialController controller =
                new MaterialController();

        boolean success =
                controller.addMaterial(

                        1,

                        txtTitle.getText(),

                        txtDescription.getText(),

                        txtFilePath.getText()
                );

        if(success){

            JOptionPane.showMessageDialog(
                    this,
                    "Material Uploaded");

        }else{

            JOptionPane.showMessageDialog(
                    this,
                    "Upload Failed");
        }
    }

    private void loadSubjects() {

        MaterialController controller =
                new MaterialController();

        for(String subject :
                controller.getAllSubjects()) {

            cmbSubject.addItem(
                    subject);
        }
    }
}