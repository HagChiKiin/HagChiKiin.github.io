package entity;

import statics.WorkerLevel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Worker extends Person{
    private int id;
    private WorkerLevel level;
    private static int AUTO_ID=1000;

    public Worker(){
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                ", level=" + level +
                '}';
    }
    @Override
    public void inputInfo(){
        super.inputInfo();

        System.out.println("Nhap bac tho: ");
        System.out.println("1. Bac 1");
        System.out.println("2. Bac 2");
        System.out.println("3. Bac 3");
        System.out.println("4. Bac 4");
        System.out.println("5. Bac 5");
        System.out.println("6. Bac 6");
        System.out.println("7. Bac 7");
        int choise ;
        do {
            try{
                choise  = new Scanner(System.in).nextInt();
                if(choise >=1 && choise <=7){
                    break;
                }
                System.out.println("lua chon khong hop le vui long nhap lai");
            }catch (InputMismatchException ex){
                System.out.println("vui long nhap so tu 1 den 7");
            }
        }
        while (true);
        switch (choise){
            case 1:
                this.setLevel(WorkerLevel.LEVEL_1);
                break;
            case 2:
                this.setLevel(WorkerLevel.LEVEL_2);
                break;
            case 3:
                this.setLevel(WorkerLevel.LEVEL_3);
                break;
            case 4:
                this.setLevel(WorkerLevel.LEVEL_4);
                break;
            case 5:
                this.setLevel(WorkerLevel.LEVEL_5);
                break;
            case 6:
                this.setLevel(WorkerLevel.LEVEL_6);
                break;
            case 7:
                this.setLevel(WorkerLevel.LEVEL_7);
                break;
            case 8:
                return;
        }
    }
}
