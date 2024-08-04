package Model;

import java.util.Date;

public class Booking {
    private Integer id;
    private Integer customer_id;
    private String customer_name;
    private Integer vehicle_id;
    private Integer vehicle_pricePerDay;
    private String vehicle_name;
    private Date start_date;
    private Date complete_date;
    private String status;
    private Integer total_days;
    private Integer total_amount;

    public Booking() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Integer getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(Integer vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public Integer getVehicle_pricePerDay() {
        return vehicle_pricePerDay;
    }

    public void setVehicle_pricePerDay(Integer vehicle_pricePerDay) {
        this.vehicle_pricePerDay = vehicle_pricePerDay;
    }

    public String getVehicle_name() {
        return vehicle_name;
    }

    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getComplete_date() {
        return complete_date;
    }

    public void setComplete_date(Date complete_date) {
        this.complete_date = complete_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotal_days() {
        return total_days;
    }

    public void setTotal_days(Integer total_days) {
        this.total_days = total_days;
    }

    public Integer getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Integer total_amount) {
        this.total_amount = total_amount;
    }

    @Override
    public String toString() {
        return "Booking{" + "id=" + id + ", customer_id=" + customer_id + ", customer_name='" + customer_name + '\'' + ", vehicle_id=" + vehicle_id + ", vehicle_pricePerDay=" + vehicle_pricePerDay + ", vehicle_name='" + vehicle_name + '\'' + ", start_date=" + start_date + ", complete_date='" + complete_date + '\'' + ", status='" + status + '\'' + ", total_days=" + total_days + ", total_amount=" + total_amount + '}';
    }
}