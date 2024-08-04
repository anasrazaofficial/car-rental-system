package Controller;


import Mapper.BookingMapper;
import Mapper.CustomerMapper;
import Mapper.VehicleMapper;
import Model.Booking;

import static SQLQueryConstant.BookingQuery.*;

import java.sql.*;
import java.util.List;

public class BookingController extends DBConnection implements Crud<Booking> {
    BookingMapper mapper = new BookingMapper();

    @Override
    public void post(Booking obj) {
        try {
            PreparedStatement psPost = conn.prepareStatement(POST);
            psPost.setInt(1, obj.getCustomer_id());
            psPost.setInt(2, obj.getVehicle_id());
            psPost.setDate(3, new Date(obj.getStart_date().getTime()));
            psPost.executeUpdate();

            PreparedStatement psVehicleUpdate = conn.prepareStatement(UPDATE_VEHICLE_STATUS);
            psVehicleUpdate.setInt(1, obj.getVehicle_id());
            psVehicleUpdate.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Booking> getAll() {
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            return mapper.resultToList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Booking obj, Integer id) {
        try {
            PreparedStatement statement = conn.prepareStatement(UPDATE);
            statement.setInt(1, obj.getCustomer_id());
            statement.setInt(2, obj.getVehicle_id());
            statement.setDate(3, new Date(obj.getStart_date().getTime()));
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Integer id) {
        try {
            PreparedStatement ps = conn.prepareStatement(DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void completeBooking(Integer id, java.util.Date completeDate, Integer vehicleId) {
        try {
            PreparedStatement statement = conn.prepareStatement(COMPLETE_BOOKING);
            statement.setDate(1, new Date(completeDate.getTime()));
            statement.setDate(2, new Date(completeDate.getTime()));
            statement.setDate(3, new Date(completeDate.getTime()));
            statement.setInt(4, id);
            statement.executeUpdate();

            PreparedStatement psVehicle = conn.prepareStatement(UPDATE_VEHICLE_STATUS_AFTER_BOOKING);
            psVehicle.setInt(1, vehicleId);
            psVehicle.executeUpdate();

            PreparedStatement psOwner = conn.prepareStatement(UPDATE_OWNER_AFTER_BOOKING);
            psOwner.setInt(1, id);
            psOwner.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
