package entity;



public class BillDetail {
    private Service service;
    private int quantity;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BillDetail(Service service, int quantity) {
        this.service = service;
        this.quantity = quantity;
    }

    public BillDetail() {
    }

    @Override
    public String toString() {
        return "BillDetail{" +
                "service=" + service +
                ", quantity=" + quantity +
                '}';
    }
}
