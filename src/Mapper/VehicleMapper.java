package Mapper;

import Model.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleMapper implements IMapper<Vehicle> {

    private final String ID = "id";
    private final String NAME = "vehc_name";
    private final String COLOR = "color";
    private final String PRICEPERDAY = "pricePerDay";
    private final String STATUS = "vehc_status";
    private final String OWNER_ID = "owner_id";
    private final String OWNER_NAME = "owner_name";

    @Override
    public List<Vehicle> resultToList(ResultSet resultSet) throws SQLException {
        List<Vehicle> vehicleList = new ArrayList<>();
        while (resultSet.next()) {
            Vehicle vehicle = new Vehicle();

            vehicle.setId(resultSet.getInt(ID));
            vehicle.setName(resultSet.getString(NAME));
            vehicle.setColor(resultSet.getString(COLOR));
            vehicle.setPricePerDay(resultSet.getInt(PRICEPERDAY));
            vehicle.setStatus(resultSet.getString(STATUS));
            vehicle.setOwner_id(resultSet.getInt(OWNER_ID));
            vehicle.setOwner_name(resultSet.getString(OWNER_NAME));

            vehicleList.add(vehicle);
        }
        return vehicleList;
    }
}