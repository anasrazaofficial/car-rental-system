package UI;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {

    private final JButton btnBooking = new JButton();
    private final JButton btnCustomer = new JButton();
    private final JButton btnLogout = new JButton();
    private final JButton btnOwner = new JButton();
    private final JButton btnVehicle = new JButton();
    private final JLabel jLabel1 = new JLabel();


    public Home() {
        setTitle("Car Rental App");
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        jLabel1.setText("Home");

        btnVehicle.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 18)); // NOI18N
        btnVehicle.setText("Vehicle");
        btnVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVehicleActionPerformed(evt);
            }
        });

        btnBooking.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 18)); // NOI18N
        btnBooking.setText("Booking");
        btnBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookingActionPerformed(evt);
            }
        });

        btnCustomer.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 18)); // NOI18N
        btnCustomer.setText("Customer");
        btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerActionPerformed(evt);
            }
        });

        btnOwner.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 18)); // NOI18N
        btnOwner.setText("Owner");
        btnOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOwnerActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(189, 189, 189))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnLogout, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btnCustomer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnOwner, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btnVehicle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnBooking, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))))
                                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnOwner, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnVehicle, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnCustomer, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBooking, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void btnVehicleActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        new VehicleUI();
    }

    private void btnBookingActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        new BookingUI();
    }

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        new CustomerUI();
    }

    private void btnOwnerActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        new OwnerUI();
    }

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        new LoginForm();
    }
}