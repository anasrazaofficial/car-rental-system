package Model;

public class Owner {
    private Integer id;
    private String name;
    private String cnic;
    private String phone_number;
    private Integer commissionPercent;
    private Integer totalCommission;
    private String address;
    private Boolean status;

    public Owner() {
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

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Integer getCommissionPercent() {
        return commissionPercent;
    }

    public void setCommissionPercent(Integer commissionPercent) {
        this.commissionPercent = commissionPercent;
    }

    public Integer getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(Integer totalCommission) {
        this.totalCommission = totalCommission;
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
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cnic=" + cnic +
                ", phone_number='" + phone_number + '\'' +
                ", commissionPercent=" + commissionPercent +
                ", totalCommission=" + totalCommission +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }
}