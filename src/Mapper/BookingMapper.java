package Mapper;


import Model.Booking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingMapper implements IMapper<Booking> {

    private static final String ID = "id";
    private static final String CUSTOMER_ID = "customer_id";
    private static final String CUSTOMER_NAME = "cust_name";
    private static final String VEHICLE_ID = "vehicle_id";
    private static final String VEHICLE_NAME = "vehc_name";
    private static final String VEHICLE_PRICEPERDAY = "pricePerDay";
    private static final String START_DATE = "start_date";
    private static final String COMPLETE_DATE = "complete_date";
    private static final String STATUS = "book_status";
    private static final String TOTAL_DAYS = "total_days";
    private static final String TOTAL_AMOUNT = "total_amount";

    @Override
    public List<Booking> resultToList(ResultSet resultSet) throws SQLException {
        List<Booking> bookingList = new ArrayList<>();
        while (resultSet.next()) {
            Booking booking = new Booking();

            booking.setId(resultSet.getInt(ID));
            booking.setCustomer_id(resultSet.getInt(CUSTOMER_ID));
            booking.setCustomer_name(resultSet.getString(CUSTOMER_NAME));
            booking.setVehicle_id(resultSet.getInt(VEHICLE_ID));
            booking.setVehicle_name(resultSet.getString(VEHICLE_NAME));
            booking.setVehicle_pricePerDay(resultSet.getInt(VEHICLE_PRICEPERDAY));
            booking.setStart_date(resultSet.getDate(START_DATE));
            booking.setComplete_date(resultSet.getDate(COMPLETE_DATE));
            booking.setStatus(resultSet.getString(STATUS));
            booking.setTotal_days(resultSet.getInt(TOTAL_DAYS));
            booking.setTotal_amount(resultSet.getInt(TOTAL_AMOUNT));

            bookingList.add(booking);
        }
        return bookingList;
    }

}