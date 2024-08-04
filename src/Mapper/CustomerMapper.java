package Mapper;


import Model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper implements IMapper<Customer> {

    private static final String ID = "id";
    private static final String NAME = "cust_name";
    private static final String PHONE_NO = "cust_phone_number";
    private static final String CNIC = "cust_cnic";
    private static final String ADDRESS = "cust_address";
    private static final String STATUS = "cust_status";


    @Override

    public List<Customer> resultToList(ResultSet resultSet) throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        while (resultSet.next()) {
            Customer customer = new Customer();

            customer.setId(resultSet.getInt(ID));
            customer.setName(resultSet.getString(NAME));
            customer.setPhone_number(resultSet.getString(PHONE_NO));
            customer.setCnic(resultSet.getString(CNIC));
            customer.setAddress(resultSet.getString(ADDRESS));
            customer.setStatus(resultSet.getBoolean(STATUS));

            customerList.add(customer);
        }
        return customerList;
    }

}
