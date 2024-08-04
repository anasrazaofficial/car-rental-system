package UI;

import Controller.OwnerController;
import Service.OwnerService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class OwnerUI extends JFrame {

    // Variables declaration - do not modify
    private final JButton btnAdd = new JButton();
    private final JButton btnBack = new JButton();
    private final JButton btnDelete = new JButton();
    private final JButton btnUpdate = new JButton();
    private final JLabel jLabel1 = new JLabel();
    private final JScrollPane jScrollPane1 = new JScrollPane();
    private final JTable table = new JTable();
    // End of variables declaration

    OwnerService ownerService = new OwnerService();
    OwnerController ownerController = new OwnerController();

    public OwnerUI() {
        initComponents();
        setTitle("Car Rental System - Owner");
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        jLabel1.setText("Owner");

        table.setModel(
                new DefaultTableModel(
                        ownerService.getAll(),
                        new String[]{
                                "Id", "Name", "CNIC", "Phone Number", "Address", "Commission (%)", "Total Commission (rs)"
                        }
                ) {
                    final Class[] types = new Class[]{
                            java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
                    };
                    final boolean[] canEdit = new boolean[]{
                            false, false, false, false, false, false, false
                    };

                    public Class getColumnClass(int columnIndex) {
                        return types[columnIndex];
                    }

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(6).setResizable(false);
        }

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnBack.setText("Back to Home");
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
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(369, 369, 369))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 721, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        new AddOwner(null, null, null, null, null, null);
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String id = (String) table.getValueAt(selectedRow, 0);
            String name = (String) table.getValueAt(selectedRow, 1);
            String cnic = (String) table.getValueAt(selectedRow, 2);
            String phone_number = (String) table.getValueAt(selectedRow, 3);
            String address = (String) table.getValueAt(selectedRow, 4);
            String commission = (String) table.getValueAt(selectedRow, 5);

            setVisible(false);
            new AddOwner(Integer.parseInt(id), name, cnic, phone_number, address, Integer.parseInt(commission));
        } else {
            JOptionPane.showMessageDialog(null, "Please select any row");
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String id = (String) table.getValueAt(selectedRow, 0);
            if (ownerController.delete(Integer.parseInt(id))) {
                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                dtm.setRowCount(0);
                Object[][] data = ownerService.getAll();
                for (Object[] row : data) {
                    dtm.addRow(row);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Someting went wrong!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select any row");
        }
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        new Home();
    }
}
