package UI;

import Service.UserService;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {
    private final JButton btnLogin = new JButton();
    private final JLabel lblLogin = new JLabel();
    private final JLabel lblUser = new JLabel();
    private final JLabel lblPassword = new JLabel();
    private final JPasswordField txtPassword = new JPasswordField();
    private final JTextField txtUser = new JTextField();

    UserService userService = new UserService();

    public LoginForm() {
        initComponents();
    }


    private void initComponents() {
        setTitle("Car Rental App");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        lblLogin.setBackground(new java.awt.Color(228, 62, 62));
        lblLogin.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        lblLogin.setText("Login Form");

        lblUser.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        lblUser.setText("Enter username:");

        lblPassword.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        lblPassword.setText("Enter password:");


        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(49, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblUser)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtUser, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(btnLogin, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblPassword)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))))
                                .addGap(43, 43, 43))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(lblLogin)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtUser)
                                        .addComponent(lblUser, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 57, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        if (!txtUser.getText().isEmpty()
                && !String.valueOf(txtPassword.getPassword()).isEmpty()
        ) {
            if (userService.isAuthenticate(txtUser.getText(), String.valueOf(txtPassword.getPassword()))) {
                JOptionPane.showMessageDialog(null, "Login successfully!");
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid credentials");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please provide username and password!");
        }
    }
}
