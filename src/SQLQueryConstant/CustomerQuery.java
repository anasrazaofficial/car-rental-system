package SQLQueryConstant;

public class CustomerQuery {
    public final static String POST = "insert into customer(cust_name, cust_phone_number, cust_cnic, cust_address, cust_status) values(?,?,?,?,true);";
    public final static String GET_ALL = "select * from customer where cust_status=true;";
    public final static String UPDATE = "update customer set cust_name = ?, cust_phone_number = ?, cust_cnic=?, cust_address=? where id = ?;";
    public final static String DELETE = "update customer set cust_status = false where id = ?";

}
