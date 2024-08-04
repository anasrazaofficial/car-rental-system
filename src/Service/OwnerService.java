package Service;

import Controller.OwnerController;
import Model.Owner;

import java.util.List;


public class OwnerService {

    OwnerController ownerController = new OwnerController();

    public void post(String name, String cnic, String phone_number, Integer commissionPercent, String address) {
        Owner owner = new Owner();

        owner.setName(name);
        owner.setCnic(cnic);
        owner.setPhone_number(phone_number);
        owner.setCommissionPercent(commissionPercent);
        owner.setAddress(address);

        ownerController.post(owner);
    }

    public String[][] getAll() {
        List<Owner> ownerList = ownerController.getAll();
        String[][] owners = new String[ownerList.size()][7];
        for (int i = 0; i < ownerList.size(); i++) {
            owners[i][0] = String.valueOf(ownerList.get(i).getId());
            owners[i][1] = ownerList.get(i).getName();
            owners[i][2] = String.valueOf(ownerList.get(i).getCnic());
            owners[i][3] = ownerList.get(i).getPhone_number();
            owners[i][4] = ownerList.get(i).getAddress();
            owners[i][5] = String.valueOf(ownerList.get(i).getCommissionPercent());
            owners[i][6] = String.valueOf(ownerList.get(i).getTotalCommission());
        }
        return owners;
    }

    public void update(String name, String cnic, String phone_number, Integer commissionPercent, String address, Integer id) {
        Owner owner = new Owner();

        owner.setName(name);
        owner.setCnic(cnic);
        owner.setPhone_number(phone_number);
        owner.setCommissionPercent(commissionPercent);
        owner.setAddress(address);

        ownerController.update(owner, id);
    }

}