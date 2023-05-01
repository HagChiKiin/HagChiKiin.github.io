package entity;

import java.util.List;


public class Bill {
    private Customer customer;
    private List<BillDetail> billDetails;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<BillDetail> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "customer=" + customer +
                ", billDetails=" + billDetails +
                '}';
    }

    public Bill(Customer customer, List<BillDetail> billDetails) {
        this.customer = customer;
        this.billDetails = billDetails;
    }
}

