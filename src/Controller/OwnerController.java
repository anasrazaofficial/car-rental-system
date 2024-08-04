package Controller;

import Mapper.OwnerMapper;
import Model.Owner;

import static SQLQueryConstant.OwnerQuery.*;

import java.sql.*;
import java.util.List;


public class OwnerController extends DBConnection implements Crud<Owner> {
    private final OwnerMapper ownerMapper = new OwnerMapper();

    @Override
    public void post(Owner obj) {
        try {
            PreparedStatement ps = conn.prepareStatement(POST);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getCnic());
            ps.setString(3, obj.getPhone_number());
            ps.setInt(4, obj.getCommissionPercent());
            ps.setString(5, obj.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Owner> getAll() {
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL);
            return ownerMapper.resultToList(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Owner obj, Integer id) {
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getCnic());
            ps.setString(3, obj.getPhone_number());
            ps.setInt(4, obj.getCommissionPercent());
            ps.setString(5, obj.getAddress());
            ps.setInt(6, id);
            ps.executeUpdate();
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
}
