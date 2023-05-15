package com.example.btvn.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManagement {
    private BookManagement bookManagement;
    private ReaderManagement readerManagement;
    private BorrowBookManagement borrowBookManagement;

    public MenuManagement() {
        this.bookManagement = new BookManagement();
        this.readerManagement =new ReaderManagement();
        this.borrowBookManagement= new BorrowBookManagement(readerManagement,bookManagement);
    }
    public void menu(){
        while (true){
            printMenu();
            int func = functionChoise();
            switch (func){
                case 1:
                    bookManagement.inputInfo();
                    break;
                case 2:
                    readerManagement.inputInfo();
                    break;
                case 3:
                    borrowBookManagement.logBorrowBook();
                    return;
                case 4:
                    return;
            }
        }
    }

    private int functionChoise() {
        int choise;
        do {
            try{
                choise = new Scanner(System.in).nextInt();
                if(choise>=1 && choise<= 3){
                    break;
                }
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại");

            }catch (InputMismatchException ex){
                System.out.println("Vui lòng nhập số từ 1 đến 3");
            }
        }while (true);
        return choise;
    }


    private void printMenu() {
        System.out.println("------------PHẦN MỀM QUẢN LÝ MƯỢN SÁCH THƯ VIỆN--------------");
        System.out.println("1. Nhập danh sách đầu sách mới và in ra màn hình");
        System.out.println("2. Nhập danh sách bạn đọc mới và in ra màn hình");
        System.out.println("3. Lập bảng QL mượn sách");
        System.out.println("4. Thoát");
        System.out.println("Xin mời chọn chức năng: ");
    }
}
