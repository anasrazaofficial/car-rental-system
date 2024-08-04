package UI;

import Service.VehicleService;

import javax.swing.*;
import java.awt.*;

public class AddVehicle extends JFrame {

    // Variables declaration - do not modify
    private final JButton btnAdd = new JButton();
    private final JButton btnBack = new JButton();
    private final JLabel lbl1 = new JLabel();
    private final JLabel lbl2 = new JLabel();
    private final JLabel lbl3 = new JLabel();
    private final JLabel lbl4 = new JLabel();
    private final JLabel lblCustomer = new JLabel();
    private final JComboBox<String> ownerIds = new JComboBox<>();
    private final JTextField txtColor = new JTextField();
    private final JTextField txtName = new JTextField();
    private final JTextField txtPricePerDay = new JTextField();
    // End of variables declaration

    private Integer id = null;
    VehicleService vehicleService = new VehicleService();

    public AddVehicle(Integer id, String name, String color, Integer pricePerDay, String owner) {
        initComponents();

        if (id != null) {
            setTitle("Car Rental System - Update Vehicle");
            btnAdd.setText("Update");

            this.id = id;
            txtName.setText(name);
            txtColor.setText(color);
            txtPricePerDay.setText(String.valueOf(pricePerDay));
            ownerIds.setSelectedItem(owner);
        } else {
            setTitle("Car Rental System - Add Vehicle");
        }
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        lblCustomer.setFont(new Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        lblCustomer.setText("Add Vehicle");

        lbl1.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        lbl1.setText("Name");

        btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lbl2.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        lbl2.setText("Color");

        lbl3.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        lbl3.setText("Price / Day");

        lbl4.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        lbl4.setText("Owner Id");

        btnBack.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        ownerIds.setModel(new DefaultComboBoxModel<>(vehicleService.getAllOwnerIds()));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbl3)
                                                                        .addComponent(txtPricePerDay, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(46, 46, 46)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbl4)
                                                                        .addComponent(ownerIds, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbl1)
                                                                        .addComponent(txtName, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(46, 46, 46)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbl2)
                                                                        .addComponent(txtColor, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(20, 20, 20))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(lblCustomer)
                                                .addGap(218, 218, 218))))
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
                                                .addComponent(txtColor, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbl3)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPricePerDay, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(lbl4)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ownerIds)))
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
        String color = txtColor.getText();
        String pricePerDay = txtPricePerDay.getText();
        String owner_id = (String) ownerIds.getSelectedItem();

        if (!name.isEmpty() && !color.isEmpty() && !pricePerDay.isEmpty()) {
            if (Integer.parseInt(pricePerDay) > 0) {
                if (id == null) {
                    vehicleService.post(name, color, Integer.parseInt(pricePerDay), Integer.parseInt(owner_id.split(",")[0]));
                } else {
                    vehicleService.update(name, color, Integer.parseInt(pricePerDay), Integer.parseInt(owner_id.split(",")[0]), id);
                }
                btnBackActionPerformed(evt);
            } else JOptionPane.showMessageDialog(null, "Price per day can't be less than 0");
        } else JOptionPane.showMessageDialog(null, "Please provide all field");
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        new VehicleUI();
    }
}
