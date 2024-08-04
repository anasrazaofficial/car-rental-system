package UI;

import javax.swing.*;

import Service.BookingService;
import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.util.Date;

public class AddBooking extends JFrame {

    // Variables declaration - do not modify
    private final JButton btnAdd = new JButton();
    private final JButton btnBack = new JButton();
    private final JComboBox<String> customerIds = new JComboBox<>();
    private final JLabel lbl1 = new JLabel();
    private final JLabel lbl2 = new JLabel();
    private final JLabel lbl3 = new JLabel();
    private final JLabel lblCustomer = new JLabel();
    private final JDateChooser startDatePicker = new JDateChooser();
    private final JComboBox<String> vehicleIds = new JComboBox<>();
    // End of variables declaration

    private Integer id = null;
    BookingService bookingService = new BookingService();

    public AddBooking(Integer id, String customer, String vehicle, Date start_date) {
        initComponents();

        if (id != null) {
            setTitle("Car Rental System - Update Booking");
            btnAdd.setText("Update");

            this.id = id;
            customerIds.setSelectedItem(customer);
            vehicleIds.setSelectedItem(vehicle);
            startDatePicker.setDate(start_date);
        } else {
            setTitle("Car Rental System - Add Booking");
        }
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        lblCustomer.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        lblCustomer.setText("Add Booking");

        lbl1.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        lbl1.setText("Customer Id");

        btnAdd.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lbl2.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        lbl2.setText("Vehicle Id");

        lbl3.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        lbl3.setText("Start Date");

        btnBack.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        customerIds.setModel(new DefaultComboBoxModel<>(bookingService.getAllCustomerIds()));

        vehicleIds.setModel(new DefaultComboBoxModel<>(bookingService.getAllVehicleIds()));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(lbl1)
                                                                                .addGap(214, 214, 214))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(customerIds, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addGap(46, 46, 46)))
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(lbl2)
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addComponent(vehicleIds, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(20, 20, 20))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(lblCustomer)
                                                .addGap(208, 208, 208))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbl3)
                                                        .addComponent(startDatePicker, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblCustomer)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbl1)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(customerIds, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbl2)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(vehicleIds)))
                                .addGap(18, 18, 18)
                                .addComponent(lbl3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startDatePicker, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        String vehicleId = (String) vehicleIds.getSelectedItem();
        String customerId = (String) customerIds.getSelectedItem();
        Date startDate = startDatePicker.getDate();

        if (startDate != null) {
            if (id == null) {
                bookingService.post(
                        Integer.parseInt(customerId.split(",")[0]),
                        Integer.parseInt(vehicleId.split(",")[0]),
                        startDate
                );
            } else {
                bookingService.update(
                        Integer.parseInt(customerId.split(",")[0]),
                        Integer.parseInt(vehicleId.split(",")[0]),
                        startDate,
                        id
                );
            }
            btnBackActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(null, "Please select the correct start date");
        }
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        new BookingUI();
    }
}