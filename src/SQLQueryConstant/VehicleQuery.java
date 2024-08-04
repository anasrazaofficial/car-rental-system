package SQLQueryConstant;

public class VehicleQuery {
    public final static String POST = "insert into vehicle (vehc_name, color, pricePerDay, owner_id, vehc_status) values(?,?,?,?,'Active');";
    public final static String GET_ALL = "SELECT v.*, o.id AS owner_id, o.owner_name FROM vehicle v INNER JOIN owner o ON o.id = v.owner_id WHERE v.vehc_status != 'Inactive';";
    public final static String UPDATE_BY_ID = "UPDATE vehicle SET vehc_name = ?, color = ?, pricePerDay = ?, owner_id = ? WHERE id = ?;";
    public final static String DELETE = "update vehicle set vehc_status = 'Inactive' where id = ?";

}