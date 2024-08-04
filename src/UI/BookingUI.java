package UI;

import Controller.BookingController;
import Service.BookingService;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookingUI extends JFrame {

    // Variables declaration - do not modify
    private final JButton btnAdd = new JButton();
    private final JButton btnBack = new JButton();
    private final JButton btnComplete = new JButton();
    private final JButton btnDelete = new JButton();
    private final JButton btnUpdate = new JButton();
    private final JLabel jLabel1 = new JLabel();
    private final JScrollPane jScrollPane1 = new JScrollPane();
    private final JTable table = new JTable();
    // End of variables declaration

    BookingService bookingService = new BookingService();
    BookingController bookingController = new BookingController();

    public BookingUI() {
        setTitle("Car Rental System - Booking");
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        jLabel1.setText("Booking");

        table.setModel(new DefaultTableModel(
                bookingService.getAll(),
                new String[]{
                        "Id", "Customer", "Vehicle", "Price / Day (rs)", "Start Date", "Complete Date", "Status", "Total Days", "Total Amount (rs)"
                }
        ) {
            final Class[] types = new Class[]{
                    Integer.class, String.class, String.class, Integer.class, String.class, String.class, String.class, Integer.class, Integer.class
            };
            final boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false
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
            table.getColumnModel().getColumn(7).setResizable(false);
            table.getColumnModel().getColumn(8).setResizable(false);
        }

        btnAdd.setText("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnBack.setText("Back to Home");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnComplete.setText("Complete");
        btnComplete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 945, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnComplete, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(526, 526, 526)
                                .addComponent(jLabel1)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                                .addGap(18, 18, 18)
                                                .addComponent(btnComplete, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void btnAddActionPerformed(ActionEvent evt) {
        setVisible(false);
        new AddBooking(null, null, null, null);
    }

    private void btnUpdateActionPerformed(ActionEvent evt) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            String id = (String) table.getValueAt(selectedRow, 0);
            String customer = (String) table.getValueAt(selectedRow, 1);
            String vehicle = (String) table.getValueAt(selectedRow, 2);
            String startDateString = (String) table.getValueAt(selectedRow, 4);

            try {
                Date startDate = dateFormat.parse(startDateString);
                setVisible(false);
                new AddBooking(Integer.parseInt(id), customer.split(",")[0], vehicle.split(",")[0], startDate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select any row");
        }
    }

    private void btnDeleteActionPerformed(ActionEvent evt) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String id = (String) table.getValueAt(selectedRow, 0);
            if (bookingController.delete(Integer.parseInt(id))) {
                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                dtm.setRowCount(0);
                Object[][] data = bookingService.getAll();
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

    private void btnCompleteActionPerformed(ActionEvent evt) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            JDateChooser dateChooser = new JDateChooser();
            int option;
            Date date = null;

            do {
                option = JOptionPane.showConfirmDialog(null, dateChooser, "Complete Date", JOptionPane.OK_CANCEL_OPTION);
                String startDateString = (String) table.getValueAt(selectedRow, 4);
                try {
                    Date startDate = dateFormat.parse(startDateString);
                    if (option == JOptionPane.OK_OPTION) {
                        Date completeDate = dateChooser.getDate();
                        if (completeDate == null) {
                            JOptionPane.showMessageDialog(null, "Please select a date.");
                        } else if (startDate.after(completeDate)) {
                            JOptionPane.showMessageDialog(null, "Complete date must be after start date");
                            dateChooser.setDate(null);
                        } else {
                            date = completeDate;
                        }
                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            } while (option == JOptionPane.OK_OPTION && dateChooser.getDate() == null);

            String id = (String) table.getValueAt(selectedRow, 0);
            String vehicle = (String) table.getValueAt(selectedRow, 2);

            bookingController.completeBooking(
                    Integer.parseInt(id),
                    date,
                    Integer.parseInt(vehicle.split(",")[0])
            );
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);
            Object[][] data = bookingService.getAll();
            for (Object[] row : data) {
                dtm.addRow(row);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select any row");
        }
    }

    private void btnBackActionPerformed(ActionEvent evt) {
        setVisible(false);
        new Home();
    }
}
