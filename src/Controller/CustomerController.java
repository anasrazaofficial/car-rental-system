package Controller;

import Mapper.CustomerMapper;
import Model.Customer;

import static SQLQueryConstant.CustomerQuery.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CustomerController extends DBConnection implements Crud<Customer> {
    private final CustomerMapper customerMapper = new CustomerMapper();

    @Override
    public void post(Customer obj) {
        try {
            PreparedStatement ps = conn.prepareStatement(POST);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getPhone_number());
            ps.setString(3, obj.getCnic());
            ps.setString(4, obj.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> getAll() {
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL);
            return customerMapper.resultToList(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Customer obj, Integer id) {
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getPhone_number());
            ps.setString(3, obj.getCnic());
            ps.setString(4, obj.getAddress());
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
}
