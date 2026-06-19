package module_1;

import controller.RegisterController;

import javax.swing.*;
import java.awt.*;
import ui.LoginFrame;

public class RegisterFrame extends JFrame {

private JTextField txtFullName;
private JTextField txtEmail;
private JTextField txtPhoneNumber;

private JPasswordField txtPassword;

private JComboBox<String> cmbRole;

private JButton btnRegister;
private JButton btnBack;

public RegisterFrame() {

    setTitle("PrimeEdu Registration");
    setSize(600, 500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    initializeUI();

    setVisible(true);
}

private void initializeUI() {

    JPanel panel = new JPanel(null);

    JLabel lblTitle =
            new JLabel("User Registration");

    lblTitle.setFont(
            new Font(
                    "Arial",
                    Font.BOLD,
                    24));

    lblTitle.setBounds(
            180,
            20,
            250,
            30);

    panel.add(lblTitle);

    JLabel lblPassword =
            new JLabel("Password:");

    lblPassword.setBounds(
            80,
            90,
            120,
            25);

    panel.add(lblPassword);

    txtPassword =
            new JPasswordField();

    txtPassword.setBounds(
            220,
            90,
            220,
            25);

    panel.add(txtPassword);

    JLabel lblFullName =
            new JLabel("Full Name:");

    lblFullName.setBounds(
            80,
            130,
            120,
            25);

    panel.add(lblFullName);

    txtFullName =
            new JTextField();

    txtFullName.setBounds(
            220,
            130,
            220,
            25);

    panel.add(txtFullName);

    JLabel lblEmail =
            new JLabel("Email:");

    lblEmail.setBounds(
            80,
            170,
            120,
            25);

    panel.add(lblEmail);

    txtEmail =
            new JTextField();

    txtEmail.setBounds(
            220,
            170,
            220,
            25);

    panel.add(txtEmail);

    JLabel lblPhone =
            new JLabel("Phone Number:");

    lblPhone.setBounds(
            80,
            210,
            120,
            25);

    panel.add(lblPhone);

    txtPhoneNumber =
            new JTextField();

    txtPhoneNumber.setBounds(
            220,
            210,
            220,
            25);

    panel.add(txtPhoneNumber);

    JLabel lblRole =
            new JLabel("Role:");

    lblRole.setBounds(
            80,
            250,
            120,
            25);

    panel.add(lblRole);

    cmbRole =
            new JComboBox<>();

    cmbRole.addItem("PARENT");
    cmbRole.addItem("INSTRUCTOR");

    cmbRole.setBounds(
            220,
            250,
            220,
            25);

    panel.add(cmbRole);

    btnRegister =
            new JButton("Register");

    btnRegister.setBounds(
            220,
            330,
            100,
            35);

    panel.add(btnRegister);

    btnBack =
            new JButton("Back");

    btnBack.setBounds(
            340,
            330,
            100,
            35);

    panel.add(btnBack);

    add(panel);

    btnRegister.addActionListener(
            e -> registerUser());

    btnBack.addActionListener(
            e -> {

                new LoginFrame();
                dispose();
            });
}

private void registerUser() {

    RegisterController controller =
            new RegisterController();

    String password =
            String.valueOf(
                    txtPassword.getPassword());

    String fullName =
            txtFullName.getText();

    String email =
            txtEmail.getText();

    String phone =
            txtPhoneNumber.getText();

    String role =
            cmbRole.getSelectedItem()
                    .toString();

    boolean success = false;

    if(role.equals("PARENT")) {

        success =
                controller.registerParent(
                        password,
                        fullName,
                        email,
                        phone
                );

    } else if(role.equals("INSTRUCTOR")) {

        success =
                controller.registerInstructor(
                        password,
                        fullName,
                        email,
                        phone
                );
    }

    if(success) {

        JOptionPane.showMessageDialog(
                this,
                "Registration Successful");

        new LoginFrame();

        dispose();

    } else {

        JOptionPane.showMessageDialog(
                this,
                "Email Already Exists");
    }
}

}
