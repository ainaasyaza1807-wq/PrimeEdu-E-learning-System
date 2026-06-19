package ui;

import module_1.RegisterFrame;
import module_1.ForgotPasswordFrame;
import controller.LoginController;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

private JTextField txtEmail;
private JPasswordField txtPassword;

private JButton btnLogin;
private JButton btnRegister;
private JButton btnForgotPassword;

public LoginFrame() {

    setTitle("PrimeEdu Login");
    setSize(500,350);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);

    initializeUI();

    setVisible(true);
}

private void initializeUI() {

    JPanel panel = new JPanel();
    panel.setLayout(null);

    JLabel lblTitle =
            new JLabel("PrimeEdu Login");

    lblTitle.setFont(
            new Font("Arial",
                    Font.BOLD,
                    24));

    lblTitle.setBounds(
            150,
            20,
            250,
            30);

    panel.add(lblTitle);

    JLabel lblEmail =
            new JLabel("Email:");

    lblEmail.setBounds(
            70,
            90,
            100,
            25);

    panel.add(lblEmail);

    txtEmail =
            new JTextField();

    txtEmail.setBounds(
            180,
            90,
            200,
            25);

    panel.add(txtEmail);

    JLabel lblPassword =
            new JLabel("Password:");

    lblPassword.setBounds(
            70,
            140,
            100,
            25);

    panel.add(lblPassword);

    txtPassword =
            new JPasswordField();

    txtPassword.setBounds(
            180,
            140,
            200,
            25);

    panel.add(txtPassword);

    btnLogin =
            new JButton("Login");

    btnLogin.setBounds(
            180,
            190,
            100,
            30);

    panel.add(btnLogin);

    btnRegister =
            new JButton("Register");

    btnRegister.setBounds(
            290,
            190,
            100,
            30);

    panel.add(btnRegister);

    btnForgotPassword =
            new JButton("Forgot Password");

    btnForgotPassword.setBounds(
            180,
            240,
            210,
            30);

    panel.add(btnForgotPassword);

    add(panel);

    btnLogin.addActionListener(
            (ActionEvent e) -> {

                loginUser();
            });

    btnRegister.addActionListener(
            (ActionEvent e) -> {

                new RegisterFrame();

                dispose();
            });

    btnForgotPassword.addActionListener(
            (ActionEvent e) -> {

                new ForgotPasswordFrame();

                dispose();
            });
}

private void loginUser() {

    String email =
            txtEmail.getText().trim();

    String password =
            String.valueOf(
                    txtPassword.getPassword()).trim();

    LoginController controller =
            new LoginController();

    User user =
            controller.login(
                    email,
                    password);

    if(user == null) {

        JOptionPane.showMessageDialog(
                this,
                "Invalid Email or Password");

        return;
    }

    JOptionPane.showMessageDialog(
            this,
            "Welcome "
            + user.getFullName());

    String role =
            controller.getRole(email);

    switch(role){

        case "ADMIN":

            new AdminDashboard();
            dispose();
            break;

        case "PARENT":

    int parentId =
            controller.getParentId(
                    user.getUserId());

    System.out.println(
            "Parent ID = "
            + parentId);

    new ParentDashboard(
            parentId);

    dispose();

    break;

        case "STUDENT":

            new StudentDashboard();
            dispose();
            break;

        case "INSTRUCTOR":

            new InstructorDashboard();
            dispose();
            break;

        default:

            JOptionPane.showMessageDialog(
                    this,
                    "Unknown User Role");
    }
}

}
