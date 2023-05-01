package logic_handle;

import entity.Factory;
import entity.TimeSheet;
import entity.TimeSheetDetail;
import entity.Worker;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TimeSheetManagement {
    private List<TimeSheet> timeSheets;
    private WorkerManagement workerManagement;
    private FactoryManagement factoryManagement;

    public TimeSheetManagement(WorkerManagement workerManagement, FactoryManagement factoryManagement) {
        this.timeSheets = new ArrayList<>();
        this.workerManagement = workerManagement;
        this.factoryManagement =factoryManagement;
    }
    public void logTimeSheet(){
        System.out.println("Muon cham cong cho bao nhieu cong nhan: ");
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
            System.out.println("Nhap id cua cong nhan thu: " +(i+1)+" ma ban muon cham cong: ");
            int workerId;
            Worker worker;
            do{
                try{
                    workerId = new Scanner(System.in).nextInt();
                    worker = workerManagement.findById(workerId);
                    if(worker != null){
                        break;
                    }
                    System.out.println("id khong ton tai trong he thong vui long nhap lai: ");
                }catch (InputMismatchException ex){
                    System.out.println("vui long nhap so :");
                }

            }while (true);
            System.out.println("Cong nhan nay lam viec o bao nhieu xuong trong thang vua roi");
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
            List<TimeSheetDetail> timeSheetDetails = new ArrayList<>();

            for (int j = 0; j < factoryNumber; j++) {
                System.out.println("Nhap ma xuong thu :"+ (j+1)+" ma cong nhan nay da lam viec trong thang vua roi");
                int factoryId;
                Factory factory;
                do{
                    try{
                        factoryId = new Scanner(System.in).nextInt();
                        factory  = factoryManagement.   findById(factoryId);
                        if(factory != null){
                            break;
                        }
                        System.out.println("id khong ton tai trong he thong vui long nhap lai: ");
                    }catch (InputMismatchException ex){
                        System.out.println("vui long nhap so :");
                    }

                }while (true);

                System.out.println("Cong nhan nay lam viec o xuogn vua nhap bao nhieu ngay: ");
                int workingDay;
                do{
                    try{
                        workingDay = new Scanner(System.in).nextInt();
                        if(workingDay>0){
                            break;
                        }
                        System.out.println("so ngay lam viec vao phai lon hon 0:");
                    }catch (InputMismatchException ex){
                        System.out.println("vui long nhap so :");
                    }
                }while (true);
                TimeSheetDetail timeSheetDetail = new TimeSheetDetail(factory, workingDay);
                timeSheetDetails.add(timeSheetDetail);
            }

            TimeSheet timeSheet = new TimeSheet(worker,timeSheetDetails);
            timeSheets.add(timeSheet);

        }
        showInfo();
    }
    public void  showInfo(){
        timeSheets.forEach(System.out::println);
    }
}
