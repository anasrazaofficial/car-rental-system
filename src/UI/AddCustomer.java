package UI;

import Service.CustomerService;

import javax.swing.*;
import java.awt.*;

public class AddCustomer extends JFrame {

    // Variables declaration - do not modify
    private final JButton btnAdd = new JButton();
    private final JButton btnBack = new JButton();
    private final JLabel lbl1 = new JLabel();
    private final JLabel lbl2 = new JLabel();
    private final JLabel lbl3 = new JLabel();
    private final JLabel lbl4 = new JLabel();
    private final JLabel lblCustomer = new JLabel();
    private final JTextField txtAddress = new JTextField();
    private final JTextField txtCnic = new JTextField();
    private final JTextField txtName = new JTextField();
    private final JTextField txtPhone = new JTextField();
    // End of variables declaration

    private Integer id = null;
    CustomerService customerService = new CustomerService();

    public AddCustomer(Integer id, String name, String phone_number, String cnic, String address) {
        initComponents();
        if (id != null) {
            setTitle("Car Rental System - Update Customer");
            btnAdd.setText("Update");

            this.id = id;
            txtName.setText(name);
            txtPhone.setText(phone_number);
            txtCnic.setText(cnic);
            txtAddress.setText(address);
        } else {
            setTitle("Car Rental System - Add Customer");
        }
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        lblCustomer.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        lblCustomer.setText("Add Customer");

        lbl1.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        lbl1.setText("Name");

        btnAdd.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lbl2.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        lbl2.setText("Phone Number");

        lbl3.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        lbl3.setText("CNIC");

        lbl4.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        lbl4.setText("Address");

        btnBack.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbl3)
                                                                        .addComponent(txtCnic, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(46, 46, 46)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbl4)
                                                                        .addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbl1)
                                                                        .addComponent(txtName, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(46, 46, 46)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbl2)
                                                                        .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(20, 20, 20))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(lblCustomer)
                                                .addGap(193, 193, 193))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblCustomer)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbl1)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtName, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbl2)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbl3)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCnic, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbl4)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
        );

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }


    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        String name = txtName.getText();
        String phone = txtPhone.getText();
        String cnic = txtCnic.getText();
        String address = txtAddress.getText();
        if (!name.isEmpty() && !phone.isEmpty() && !cnic.isEmpty() && !address.isEmpty()) {
            if (this.id == null) {
                customerService.post(name, phone, cnic, address);
            } else {
                customerService.update(name, phone, cnic, address, id);
            }
            btnBackActionPerformed(evt);
        } else JOptionPane.showMessageDialog(null, "Please provide all field");
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        new CustomerUI();
    }
}
