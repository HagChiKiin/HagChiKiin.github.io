package logic_handle;

import entity.Service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ServiceManagement {
    private List<Service> services;

    public ServiceManagement() {
        this.services = new ArrayList<>();
    }

    public void inputInfo() {
        System.out.println("Ban muon nhap bao nhiu dich vu:");
        int serviceNumber;

        do{
            try{
                serviceNumber = new Scanner(System.in).nextInt();
                if(serviceNumber>0){
                    break;
                }
                System.out.println("so luong dich vu nhap vao phai lon hon 0:");
            }catch (InputMismatchException ex){
                System.out.println("vui long nhap so :");
            }
        }while (true);
        for (int i = 0; i < 2; i++) {
            Service service = new Service();
            service.inputInfo();
            services.add(service);
        }
        showService();
    }

    public void showService(){
        services.forEach(System.out::println);
    }
    public Service findById(int id){
        for (int i = 0; i < services.size(); i++) {
            if(services.get(i).getId() == id){
                return  services.get(i);
            }
        }
        return null;

    }
}
