package module_1;

import controller.ForgotPasswordController;

import javax.swing.*;
import java.awt.*;
import ui.LoginFrame;

public class ForgotPasswordFrame extends JFrame {

    private JTextField txtEmail;
    private JPasswordField txtNewPassword;

    private JButton btnReset;
    private JButton btnBack;

    public ForgotPasswordFrame() {

        setTitle("Forgot Password");
        setSize(500,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeUI();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel = new JPanel(null);

        JLabel lblTitle =
                new JLabel("Reset Password");

        lblTitle.setFont(
                new Font("Arial",
                        Font.BOLD,
                        22));

        lblTitle.setBounds(
                150,
                30,
                250,
                30);

        panel.add(lblTitle);

        JLabel lblEmail =
                new JLabel("Email:");

        lblEmail.setBounds(
                70,
                100,
                100,
                25);

        panel.add(lblEmail);

        txtEmail =
                new JTextField();

        txtEmail.setBounds(
                180,
                100,
                200,
                25);

        panel.add(txtEmail);

        JLabel lblPassword =
                new JLabel("New Password:");

        lblPassword.setBounds(
                70,
                150,
                100,
                25);

        panel.add(lblPassword);

        txtNewPassword =
                new JPasswordField();

        txtNewPassword.setBounds(
                180,
                150,
                200,
                25);

        panel.add(txtNewPassword);

        btnReset =
                new JButton("Reset");

        btnReset.setBounds(
                180,
                210,
                90,
                35);

        panel.add(btnReset);

        btnBack =
                new JButton("Back");

        btnBack.setBounds(
                290,
                210,
                90,
                35);

        panel.add(btnBack);

        add(panel);

        btnReset.addActionListener(
                e -> resetPassword());

        btnBack.addActionListener(
                e -> {

                    new LoginFrame();
                    dispose();
                });
    }

    private void resetPassword() {

        String email =
                txtEmail.getText();

        String password =
                String.valueOf(
                        txtNewPassword.getPassword());

        ForgotPasswordController controller =
                new ForgotPasswordController();

        boolean success =
                controller.resetPassword(
                        email,
                        password);

        if(success){

            JOptionPane.showMessageDialog(
                    this,
                    "Password Updated Successfully");

            new LoginFrame();

            dispose();

        }else{

            JOptionPane.showMessageDialog(
                    this,
                    "Email Not Found");
        }
    }
}