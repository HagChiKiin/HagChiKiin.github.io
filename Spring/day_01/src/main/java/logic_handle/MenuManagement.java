package logic_handle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManagement {
    private final WorkerManagement workerManagement ;
    private TimeSheetManagement timeSheetManagement;
    private FactoryManagement factoryManagement;

    public MenuManagement() {
        this.workerManagement = new WorkerManagement();
        this.timeSheetManagement = new TimeSheetManagement(workerManagement, factoryManagement);
        this.factoryManagement = new FactoryManagement();
    }

    public void menu(){
      while (true){
          printMenu();
          int functionChoise = functionChoise();
          switch (functionChoise){
              case 1:
                  workerManagement.inputInfo();
                  break;
              case 2:
                  factoryManagement.inputInfo();
                  break;
              case 3:
                  timeSheetManagement.showInfo();
                  break;
              case 4:
                  break;
              case 5:
                  break;
              case 6:
                  return;
          }
      }
    }

    private void printMenu() {
        System.out.println("-----------Phần mềm quản lý --------------");
        System.out.println("1. nhap danh sach cong nhan moi va in ra man hinh");
        System.out.println("2. nhap danh sach phan xuong moi va in ra man hinh");
        System.out.println("3. lap bang cham cong cho nhan vien");
        System.out.println("4. sap xep bang cham cong");
        System.out.println("5. lap bang ke thu nhap");
        System.out.println("6. Thoat");
        System.out.println("xin moi chon chuc nang");
    }
    private int functionChoise(){
        int choise ;
        do {
            try{
                choise  = new Scanner(System.in).nextInt();
                if(choise >=1 && choise <=6){
                    break;
                }
                System.out.println("lua chon khong hop le vui long nhap lai");
            }catch (InputMismatchException ex){
                System.out.println("vui long nhap so tu 1 den 6");
            }
        }
        while (true);
        return choise;
    }
}
