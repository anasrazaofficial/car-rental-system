package Model;


public class Customer {
    private Integer id;
    private String name;
    private String phone_number;
    private String cnic;
    private String address;
    private Boolean status;

    public Customer() {
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customer_name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", cnic='" + cnic + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}