package logic_handle;

import entity.Factory;
import entity.Worker;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FactoryManagement {
    private List<Factory> factories;

    public FactoryManagement() {
        this.factories = new ArrayList<>();
    }

    public void inputInfo(){
        System.out.println("Ban muon nhap cho bao nhieu xuong:");
        int factoryNumber;
        do{
            try{
                factoryNumber = new Scanner(System.in).nextInt();
                if(factoryNumber>0){
                    break;
                }
                System.out.println("so luong xuong nhap vao phai lon hon 0:");
            }catch (InputMismatchException ex){
                System.out.println("vui long nhap so :");
            }
        }while (true);
        for (int i = 0; i < factoryNumber; i++) {
            Factory factory = new Factory();
            factory.inputInfo();
            factories.add(factory);
        }
        showWorker();
    }

    public void showWorker(){
        factories.forEach(System.out::println);
    }
    public Factory findById(int id){
        for (int i = 0; i < factories.size(); i++) {
            if(factories.get(i).getId() == id){
                return  factories.get(i);
            }
        }
        return null;
    }
}
