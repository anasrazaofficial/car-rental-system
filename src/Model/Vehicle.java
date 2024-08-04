package Model;

public class Vehicle {
    private Integer id;
    private String name;
    private String color;
    private Integer pricePerDay;
    private String status;
    private Integer owner_id;
    private String owner_name;

    public Vehicle() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Integer pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicle_name='" + name + '\'' +
                ", vehicle_color='" + color + '\'' +
                ", vehicle_price=" + pricePerDay +
                ", status='" + status + '\'' +
                ", owner_id=" + owner_id +
                ", owner_name='" + owner_name + '\'' +
                '}';
    }
}