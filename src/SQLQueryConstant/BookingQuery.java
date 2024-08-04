package SQLQueryConstant;

public class BookingQuery {
    public final static String POST = "insert into booking (customer_id, vehicle_id,start_date, book_status) values(?,?,?,'Active');";
    public final static String UPDATE_VEHICLE_STATUS = "UPDATE vehicle SET vehc_status = 'Booked' WHERE id = ?;";

    public final static String GET_ALL = "SELECT b.*, c.id AS customer_id, c.cust_name, v.id AS vehicle_id, v.vehc_name, v.pricePerDay FROM booking b INNER JOIN vehicle v ON b.vehicle_id = v.id INNER JOIN customer c ON b.customer_id = c.id WHERE b.book_status != 'Inactive';";

    public final static String UPDATE = "update booking set customer_id = ?, vehicle_id = ?, start_date=? where id = ?";

    public final static String COMPLETE_BOOKING = "UPDATE booking b INNER JOIN vehicle v ON b.vehicle_id = v.id SET  b.complete_date = ?, b.book_status = 'Completed', b.total_days = DATEDIFF(?, b.start_date), b.total_amount = v.pricePerDay * DATEDIFF(?, b.start_date) WHERE b.id = ?;";
    public final static String UPDATE_VEHICLE_STATUS_AFTER_BOOKING = "UPDATE vehicle set vehc_status='Active' where id=?;";
    public final static String UPDATE_OWNER_AFTER_BOOKING = "UPDATE owner o INNER JOIN vehicle v ON o.id = v.owner_id INNER JOIN booking b ON v.id = b.vehicle_id SET o.totalCommission = o.totalCommission + ((o.commissionPercent / 100) * b.total_amount) WHERE b.id = ?;";

    public final static String DELETE = "DELETE from booking where id=?;";
}