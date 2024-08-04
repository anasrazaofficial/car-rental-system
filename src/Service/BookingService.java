package Service;


import Controller.BookingController;
import Controller.CustomerController;
import Controller.VehicleController;
import Model.Booking;
import Model.Customer;
import Model.Owner;
import Model.Vehicle;

import java.util.Date;
import java.util.List;

public class BookingService {
    BookingController bookingController = new BookingController();
    VehicleController vehicleController = new VehicleController();
    CustomerController customerController = new CustomerController();

    public void post(Integer customer_id, Integer vehicle_id, Date start_date) {
        Booking booking = new Booking();

        booking.setCustomer_id(customer_id);
        booking.setVehicle_id(vehicle_id);
        booking.setStart_date(start_date);

        bookingController.post(booking);
    }

    public String[][] getAll() {
        List<Booking> bookingList = bookingController.getAll();
        String[][] bookings = new String[bookingList.size()][9];

        for (int i = 0; i < bookingList.size(); i++) {
            bookings[i][0] = String.valueOf(bookingList.get(i).getId());

            bookings[i][1] = bookingList.get(i).getCustomer_id() + ", ";
            bookings[i][1] += bookingList.get(i).getCustomer_name();

            bookings[i][2] = bookingList.get(i).getVehicle_id() + ", ";
            bookings[i][2] += bookingList.get(i).getVehicle_name();

            bookings[i][3] = String.valueOf(bookingList.get(i).getVehicle_pricePerDay());

            bookings[i][4] = String.valueOf(bookingList.get(i).getStart_date());

            if (bookingList.get(i).getComplete_date() == null) {
                bookings[i][5] = "--";
            } else {
                bookings[i][5] = String.valueOf(bookingList.get(i).getComplete_date());
            }

            bookings[i][6] = bookingList.get(i).getStatus();
            bookings[i][7] = String.valueOf(bookingList.get(i).getTotal_days());
            bookings[i][8] = String.valueOf(bookingList.get(i).getTotal_amount());
        }

        return bookings;
    }

    public void update(Integer customer_id, Integer vehicle_id, Date start_date, Integer id) {
        Booking booking = new Booking();

        booking.setCustomer_id(customer_id);
        booking.setVehicle_id(vehicle_id);
        booking.setStart_date(start_date);

        bookingController.update(booking, id);
    }

    public String[] getAllCustomerIds() {
        List<Customer> customerList = customerController.getAll();
        if (customerList.isEmpty()) {
            return new String[0];
        }

        String[] customers = new String[customerList.size()];
        for (int i = 0; i < customerList.size(); i++) {
            customers[i] = customerList.get(i).getId() + ", ";
            customers[i] += customerList.get(i).getName();
        }
        return customers;
    }

    public String[] getAllVehicleIds() {
        List<Vehicle> vehicleList = vehicleController.getAll();
        if (vehicleList.isEmpty()) {
            return new String[0];
        }

        String[] vehicles = new String[vehicleList.size()];
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getStatus().equals("Active")) {
                vehicles[i] = vehicleList.get(i).getId() + ", ";
                vehicles[i] += vehicleList.get(i).getName();
            }
        }
        return vehicles;
    }
}