package Service;

import Controller.OwnerController;
import Controller.VehicleController;
import Model.Owner;
import Model.Vehicle;

import java.util.List;

public class VehicleService {
    VehicleController vehicleController = new VehicleController();
    OwnerController ownerController = new OwnerController();

    public void post(String name, String color, Integer pricePerDay, Integer owner_id) {
        Vehicle vehicle = new Vehicle();

        vehicle.setName(name);
        vehicle.setColor(color);
        vehicle.setPricePerDay(pricePerDay);
        vehicle.setOwner_id(owner_id);

        vehicleController.post(vehicle);
    }

    public String[][] getAll() {
        List<Vehicle> vehicleList = vehicleController.getAll();
        String[][] data = new String[vehicleList.size()][6];
        for (int i = 0; i < vehicleList.size(); i++) {
            data[i][0] = String.valueOf(vehicleList.get(i).getId());
            data[i][1] = vehicleList.get(i).getName();
            data[i][2] = vehicleList.get(i).getColor();
            data[i][3] = String.valueOf(vehicleList.get(i).getPricePerDay());
            data[i][4] = vehicleList.get(i).getOwner_id() + ", ";
            data[i][4] += vehicleList.get(i).getOwner_name();
            data[i][5] = vehicleList.get(i).getStatus();
        }
        return data;
    }

    public void update(String name, String color, Integer pricePerDay, Integer owner_id, Integer id) {
        Vehicle vehicle = new Vehicle();

        vehicle.setName(name);
        vehicle.setColor(color);
        vehicle.setPricePerDay(pricePerDay);
        vehicle.setOwner_id(owner_id);

        vehicleController.update(vehicle, id);
    }

    public String[] getAllOwnerIds() {
        List<Owner> ownerList = ownerController.getAll();
        if (ownerList.isEmpty()) {
            return new String[0];
        }

        String[] ownerIds = new String[ownerList.size()];
        for (int i = 0; i < ownerList.size(); i++) {
            ownerIds[i] = ownerList.get(i).getId() + ", ";
            ownerIds[i] += ownerList.get(i).getName();
        }
        return ownerIds;
    }

}