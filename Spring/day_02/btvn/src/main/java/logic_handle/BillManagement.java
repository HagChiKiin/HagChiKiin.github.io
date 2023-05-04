package logic_handle;

import entity.Bill;
import entity.BillDetail;
import entity.Customer;
import entity.Service;

import java.util.*;

public class BillManagement {
    private List<Bill> bills;
    private CustomerManagement customerManagement;
    private ServiceManagement serviceManagement;
    private List<BillDetail> billDetails;

    public BillManagement(CustomerManagement customerManagement,ServiceManagement serviceManagement) {
        this.bills = new ArrayList<>();
        this.customerManagement = customerManagement;
        this.serviceManagement = serviceManagement;
    }

    public void bill(){
        System.out.println("Bạn muôn nhâp hoa đơn cho bao nhiêu khách hàng: ");
        int billNumber;
        do{
            try{
                billNumber = new Scanner(System.in).nextInt();
                if(billNumber>0 ){
                    break;
                }
                System.out.println("so luong hoa don nhap vao phai lon hon 0:");
            }catch (InputMismatchException ex){
                System.out.println("vui long nhap so :");
            }
        }while (true);
        for (int i = 0; i < billNumber; i++) {
            System.out.println("Nhap id cua khach hang thu: " +(i+1)+" ma ban muon lâp: ");
            int customerId;
             Customer customer;
            do{
                try{
                    customerId = new Scanner(System.in).nextInt();
                    customer = customerManagement.findById(customerId);
                    if(customer != null){
                        break;
                    }
                    System.out.println("id khong ton tai trong he thong vui long nhap lai: ");
                }catch (InputMismatchException ex){
                    System.out.println("vui long nhap so :");
                }

            }while (true);
            System.out.println("khach hang nay su dung bao nhieu dich vu");
            int serviceNumber;
            do{
                try{
                    serviceNumber = new Scanner(System.in).nextInt();
                    if(serviceNumber>0 && serviceNumber <=5){
                        break;
                    }
                    System.out.println("so luong dich vu nhap vao phai lon hon 0 va nho hon 6");
                }catch (InputMismatchException ex){
                    System.out.println("vui long nhap so :");
                }
            }while (true);
            List<BillDetail> billDetails = new ArrayList<>();

            for (int j = 0; j < serviceNumber; j++) {
                System.out.println("Nhap ma dich vu thu :"+ (j+1)+" ma khach hang "+customerId+" nay da su dung ");
                int serviceId;
                Service service;
                do{
                    try{
                        serviceId = new Scanner(System.in).nextInt();
                        service  = serviceManagement.findById(serviceId);
                        if(service != null){
                            break;
                        }
                        System.out.println("id khong ton tai trong he thong vui long nhap lai: ");
                    }catch (InputMismatchException ex){
                        System.out.println("vui long nhap so :");
                    }
                }while (true);
                System.out.println("Khach hang"+customerId+" da su dung bao nhieu dich vu nay bao nhieu lan: ");
                int serviceTotal;
                do{
                    try{
                        serviceTotal = new Scanner(System.in).nextInt();
                        if(serviceTotal>0){
                            break;
                        }
                        System.out.println("so dich vu phai lon hon 0:");
                    }catch (InputMismatchException ex){
                        System.out.println("vui long nhap so :");
                    }
                }while (true);

                BillDetail billDetail = new BillDetail(service, serviceTotal);
                billDetails.add(billDetail);
            }

            Bill bill = new Bill(customer,billDetails);

            bills.add(bill);

        }
        showInfo();
    }
    public void  showInfo(){
        bills.forEach(System.out::println);
    }

    //4. Sắp xếp
    public void sortByName(){
        bills.sort(Comparator.comparing(o -> o.getCustomer().getName()));
        for (Bill  b : bills
             ) {
            System.out.println(b);
        }
    }
    public void sortByQuantity(){
        Comparator<BillDetail> Comparator = (o1, o2) -> o2.getQuantity() - o1.getQuantity();
        billDetails.sort(Comparator);
    }
    public void sort(){
        sortByQuantity();
        for (Bill b : bills
             ) {
            System.out.println(b);
        }
    }
    public void totalMoney(){
        bill();

    }
    // 5. Lập bảng kê số tiền phải trả --
    public double getTotal() {
        double total = 0;
        for (BillDetail b : billDetails) {
            total += b.getService().getPrice() * b.getQuantity();
        }
        return total;
    }
    //TODO- chưa làm được

}
