package logic_handle;

import entity.Customer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CustomerManagement {
    private  List<Customer> customers ;

    public CustomerManagement() {
        this.customers = new ArrayList<>();
    }

    public void inputInfo() {
        System.out.println("ban muon nhap cho bao nhieu khach hang");
        int customerNumber;
        do{
            try{
                customerNumber = new Scanner(System.in).nextInt();
                if(customerNumber>0){
                    break;
                }
                System.out.println("so luong khac hang nhap vao phai lon hon 0:");
            }catch (InputMismatchException ex){
                System.out.println("vui long nhap so :");
            }
        }while (true);
        for (int i = 0; i < customerNumber; i++) {
            Customer customer = new Customer();
            customer.inputInfo();
            customers.add(customer);
        }
        showCustomer();
    }

    public void showCustomer(){
        customers.forEach(System.out::println);
    }
    public Customer findById(int id){
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getId() == id){
                return  customers.get(i);
            }
        }
        return null;
    }

}
