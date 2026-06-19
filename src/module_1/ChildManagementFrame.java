package module_1;

import ui.ParentDashboard;
import controller.ChildController;
import entity.ChildProfile;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ChildManagementFrame extends JFrame {

    private JTextField txtChildId;
    private JTextField txtChildName;
    private JTextField txtChildEmail;
    private JTextField txtChildPassword;
    private JTextField txtSchoolName;

    private JTextField txtSearchId;

    private JComboBox<String> cmbStandard;

    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnSearch;
    private JButton btnRefresh;
    private JButton btnClear;
    private JButton btnBack;

    private JTable tblChildren;
    private DefaultTableModel model;

   private int parentId;

    public ChildManagementFrame(
        int parentId) {

    this.parentId = parentId;

    setTitle(
            "PrimeEdu - Child Management");

    setSize(1000,650);

    setLocationRelativeTo(null);

    setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);

    initializeUI();

    loadChildren();

    setVisible(true);
}

    private void initializeUI() {

        JPanel panel = new JPanel(null);

        panel.setBackground(
                new Color(245,248,250));

        JLabel lblTitle =
                new JLabel(
                        "CHILD MANAGEMENT");

        lblTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24));

        lblTitle.setForeground(
                new Color(
                        0,
                        102,
                        204));

        lblTitle.setBounds(
                360,
                20,
                300,
                30);

        panel.add(lblTitle);

        //------------------------------------
        // FORM SECTION
        //------------------------------------

        JLabel lblChildId =
                new JLabel("Child ID:");

        lblChildId.setBounds(
                50,
                80,
                120,
                25);

        panel.add(lblChildId);

        txtChildId =
        new JTextField();

    txtChildId.setEditable(false);

        txtChildId.setBounds(
                180,
                80,
                220,
                25);

        panel.add(txtChildId);

        JLabel lblChildName =
                new JLabel("Child Name:");

        lblChildName.setBounds(
                50,
                120,
                120,
                25);

        panel.add(lblChildName);

        txtChildName =
                new JTextField();

        txtChildName.setBounds(
                180,
                120,
                220,
                25);

        panel.add(txtChildName);

        JLabel lblEmail =
                new JLabel("Student Email:");

        lblEmail.setBounds(
                50,
                160,
                120,
                25);

        panel.add(lblEmail);

        txtChildEmail =
                new JTextField();

        txtChildEmail.setBounds(
                180,
                160,
                220,
                25);

        panel.add(txtChildEmail);

        JLabel lblPassword =
                new JLabel("Password:");

        lblPassword.setBounds(
                50,
                200,
                120,
                25);

        panel.add(lblPassword);

        txtChildPassword =
                new JTextField();

        txtChildPassword.setBounds(
                180,
                200,
                220,
                25);

        panel.add(txtChildPassword);

        JLabel lblStandard =
                new JLabel("Standard:");

        lblStandard.setBounds(
                50,
                240,
                120,
                25);

        panel.add(lblStandard);

        cmbStandard =
                new JComboBox<>();

        cmbStandard.addItem("Standard 4");
        cmbStandard.addItem("Standard 5");
        cmbStandard.addItem("Standard 6");

        cmbStandard.setBounds(
                180,
                240,
                220,
                25);

        panel.add(cmbStandard);

        JLabel lblSchool =
                new JLabel("School Name:");

        lblSchool.setBounds(
                50,
                280,
                120,
                25);

        panel.add(lblSchool);

        txtSchoolName =
                new JTextField();

        txtSchoolName.setBounds(
                180,
                280,
                220,
                25);

        panel.add(txtSchoolName);

        //------------------------------------
        // SEARCH SECTION
        //------------------------------------

        JLabel lblSearch =
                new JLabel("Search Child ID:");

        lblSearch.setBounds(
                520,
                80,
                120,
                25);

        panel.add(lblSearch);

        txtSearchId =
                new JTextField();

        txtSearchId.setBounds(
                650,
                80,
                150,
                25);

        panel.add(txtSearchId);

        //------------------------------------
        // BUTTONS
        //------------------------------------

        btnAdd =
                new JButton("Add");

        btnUpdate =
                new JButton("Update");

        btnDelete =
                new JButton("Delete");

        btnSearch =
                new JButton("Search");

        btnRefresh =
                new JButton("Refresh");

        btnClear =
                new JButton("Clear");

        btnBack =
                new JButton("Back");

        btnAdd.setBounds(520,140,120,35);
        btnUpdate.setBounds(660,140,120,35);
        btnDelete.setBounds(800,140,120,35);

        btnSearch.setBounds(520,190,120,35);
        btnRefresh.setBounds(660,190,120,35);
        btnClear.setBounds(800,190,120,35);

        btnBack.setBounds(660,240,120,35);

        panel.add(btnAdd);
        panel.add(btnUpdate);
        panel.add(btnDelete);
        panel.add(btnSearch);
        panel.add(btnRefresh);
        panel.add(btnClear);
        panel.add(btnBack);

        //------------------------------------
        // TABLE
        //------------------------------------

        model =
                new DefaultTableModel();

        model.addColumn("Child ID");
        model.addColumn("Child Name");
        model.addColumn("Email");
        model.addColumn("Standard");
        model.addColumn("School Name");

        tblChildren =
                new JTable(model);

        JScrollPane scrollPane =
                new JScrollPane(tblChildren);

        scrollPane.setBounds(
                40,
                350,
                900,
                220);

        panel.add(scrollPane);

        add(panel);

        //------------------------------------
        // EVENTS
        //------------------------------------

        btnAdd.addActionListener(
                e -> addChild());

        btnUpdate.addActionListener(
                e -> updateChild());

        btnDelete.addActionListener(
                e -> deleteChild());

        btnSearch.addActionListener(
                e -> searchChild());

        btnRefresh.addActionListener(
                e -> loadChildren());

        btnClear.addActionListener(
                e -> clearForm());

        btnBack.addActionListener(e -> {

        new ParentDashboard(parentId);

        dispose();

});

        tblChildren.getSelectionModel()
                .addListSelectionListener(e -> {

                    int row =
                            tblChildren.getSelectedRow();

                    if(row >= 0){

                        txtChildId.setText(
                                model.getValueAt(
                                        row,
                                        0).toString());

                        txtChildName.setText(
                                model.getValueAt(
                                        row,
                                        1).toString());

                        txtChildEmail.setText(
                                model.getValueAt(
                                        row,
                                        2).toString());

                        cmbStandard.setSelectedItem(
                                model.getValueAt(
                                        row,
                                        3).toString());

                        txtSchoolName.setText(
                                model.getValueAt(
                                        row,
                                        4).toString());
                    }
                });
    }

    private void clearForm(){

        txtChildId.setText("");
        txtChildName.setText("");
        txtChildEmail.setText("");
        txtChildPassword.setText("");
        txtSchoolName.setText("");
        txtSearchId.setText("");

        cmbStandard.setSelectedIndex(0);
    }

    // GUNA METHOD LAMA KAU

    private void addChild() {

    ChildController controller =
            new ChildController();

    boolean success =
            controller.addChild(
                    parentId,
                    txtChildName.getText(),
                    txtChildEmail.getText(),
                    txtChildPassword.getText(),
                    cmbStandard.getSelectedItem().toString(),
                    txtSchoolName.getText()
            );

    if(success){

        JOptionPane.showMessageDialog(
                this,
                "Child Added Successfully");

        clearForm();
        loadChildren();

    }else{

        JOptionPane.showMessageDialog(
                this,
                "Failed To Add Child");
    }
}

    private void updateChild() {

    if(txtChildId.getText().isEmpty()){

        JOptionPane.showMessageDialog(
                this,
                "Select Child First");

        return;
    }

    ChildController controller =
            new ChildController();

    boolean success =
            controller.updateChild(

                    Integer.parseInt(
                            txtChildId.getText()),

                    txtChildName.getText(),

                    txtChildEmail.getText(),

                    txtChildPassword.getText(),

                    cmbStandard.getSelectedItem().toString(),

                    txtSchoolName.getText()
            );

    if(success){

        JOptionPane.showMessageDialog(
                this,
                "Child Updated");

        loadChildren();

    }else{

        JOptionPane.showMessageDialog(
                this,
                "Update Failed");
    }
}

    private void deleteChild() {

    if(txtChildId.getText().isEmpty()){

        JOptionPane.showMessageDialog(
                this,
                "Select Child First");

        return;
    }

    ChildController controller =
            new ChildController();

    boolean success =
            controller.deleteChild(

                    Integer.parseInt(
                            txtChildId.getText())
            );

    if(success){

        JOptionPane.showMessageDialog(
                this,
                "Child Deleted");

        clearForm();
        loadChildren();

    }else{

        JOptionPane.showMessageDialog(
                this,
                "Delete Failed");
    }
}

    private void searchChild() {

    if(txtSearchId.getText().isEmpty()){

        JOptionPane.showMessageDialog(
                this,
                "Enter Child ID");

        return;
    }

    ChildController controller =
            new ChildController();

    ChildProfile child =
            controller.searchChild(

                    Integer.parseInt(
                            txtSearchId.getText())
            );

    if(child != null){

        txtChildId.setText(
                String.valueOf(
                        child.getChildId()));

        txtChildName.setText(
                child.getChildName());

        txtChildEmail.setText(
                child.getChildEmail());

        txtChildPassword.setText(
                child.getChildPassword());

        cmbStandard.setSelectedItem(
                child.getStandard());

        txtSchoolName.setText(
                child.getSchoolName());

    }else{

        JOptionPane.showMessageDialog(
                this,
                "Child Not Found");
    }
}

    private void loadChildren() {

    model.setRowCount(0);

    ChildController controller =
            new ChildController();

    ArrayList<ChildProfile> list =
            controller.getAllChildren(
                    parentId);

    for(ChildProfile child : list){

        model.addRow(new Object[]{

                child.getChildId(),
                child.getChildName(),
                child.getChildEmail(),
                child.getStandard(),
                child.getSchoolName()
        });
    }
    }
}