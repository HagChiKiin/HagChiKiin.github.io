package logic_handle;

import entity.Worker;
import statics.WorkerLevel;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class WorkerManagement {
    private final List<Worker> workers;

    public WorkerManagement() {
        this.workers = new ArrayList<>();
    }

    public void inputInfo(){
        System.out.println("Ban muon nhap cho bao nhieu cong nhan:");
        int workerNumber;
        do{
            try{
                workerNumber = new Scanner(System.in).nextInt();
                if(workerNumber>0){
                    break;
                }
                System.out.println("so luong cong nhan nhap vao phai lon hon 0:");
            }catch (InputMismatchException ex){
                System.out.println("vui long nhap so :");
            }
        }while (true);
        for (int i = 0; i < workerNumber; i++) {
            Worker worker = new Worker();
            worker.inputInfo();
            workers.add(worker);
        }
        showWorker();
    }

    public void showWorker(){
        workers.forEach(System.out::println);
    }
    public Worker findById(int id){
        for (int i = 0; i < workers.size(); i++) {
            if(workers.get(i).getId() == id){
                return  workers.get(i);
            }

        }
        return null;
    }
}
