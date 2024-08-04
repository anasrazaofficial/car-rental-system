package Service;

import Controller.CustomerController;
import Model.Customer;

import java.util.List;

public class CustomerService {
    CustomerController dao = new CustomerController();

    public void post(String name, String phone_number, String cnic, String address) {
        Customer customer = new Customer();

        customer.setName(name);
        customer.setPhone_number(phone_number);
        customer.setCnic(cnic);
        customer.setAddress(address);

        dao.post(customer);
    }

    public String[][] getAll() {
        List<Customer> customerList = dao.getAll();
        String[][] customers = new String[customerList.size()][5];
        for (int i = 0; i < customerList.size(); i++) {
            customers[i][0] = String.valueOf(customerList.get(i).getId());
            customers[i][1] = customerList.get(i).getName();
            customers[i][2] = customerList.get(i).getPhone_number();
            customers[i][3] = String.valueOf(customerList.get(i).getCnic());
            customers[i][4] = customerList.get(i).getAddress();
        }
        return customers;
    }

    public void update(String name, String phone_number, String cnic, String address, Integer id) {
        Customer customer = new Customer();

        customer.setName(name);
        customer.setPhone_number(phone_number);
        customer.setCnic(cnic);
        customer.setAddress(address);

        dao.update(customer, id);
    }
}