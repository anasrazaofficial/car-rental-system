package SQLQueryConstant;

public class OwnerQuery {
    public final static String POST = "insert into owner (owner_name, owner_cnic, owner_phone_number, commissionPercent, totalCommission, owner_address, owner_status) values(?,?,?,?, 0,?,true);";
    public final static String GET_ALL = "select * from owner where owner_status=true;";
    public final static String UPDATE = "update owner set owner_name=?, owner_cnic=?, owner_phone_number=?, commissionPercent=?, owner_address=? where id = ?;";
    public final static String DELETE = "update owner set owner_status=false where id = ?";
}
