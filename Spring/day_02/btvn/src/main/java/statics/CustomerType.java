package statics;

public enum CustomerType {
    CA_NHAN("CN"), HANH_CHINH("HC"), KINH_DOANH("KD");

    public String customerType;

    CustomerType(String customerType) {
        this.customerType = customerType;
    }
}
