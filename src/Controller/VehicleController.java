package Controller;

import Mapper.VehicleMapper;
import Model.Vehicle;

import static SQLQueryConstant.VehicleQuery.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class VehicleController extends DBConnection implements Crud<Vehicle> {
    VehicleMapper mapper = new VehicleMapper();

    @Override
    public void post(Vehicle obj) {
        try {
            PreparedStatement ps = conn.prepareStatement(POST);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getColor());
            ps.setInt(3, obj.getPricePerDay());
            ps.setInt(4, obj.getOwner_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Vehicle> getAll() {
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            return mapper.resultToList(resultSet);
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

    @Override
    public void update(Vehicle obj, Integer id) {
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE_BY_ID);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getColor());
            ps.setInt(3, obj.getPricePerDay());
            ps.setInt(4, obj.getOwner_id());
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}