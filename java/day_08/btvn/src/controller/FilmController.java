package controller;

import service.FilmService;

import java.util.Scanner;

public class FilmController {
    public FilmService filmService = new FilmService();
    public void run(){
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;
        while (!isQuit){
            showMenu();
            System.out.println("Nhập lựa chọn: ");
            option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1:{
                    System.out.println("Hiển thị thông tin phim: ");
                    filmService.showFilm();
                    break;
                }
                case 2:{
                    System.out.println("Nhập tiêu đề phim cần tìm: ");
                    String title = sc.nextLine();
                    filmService.findByTitle(title);
                    break;
                }
                case 3:{
                    isQuit =  true;
                    System.out.println("Good bye");
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
                }
            }
        }
    }
    public static void showMenu(){
        System.out.println("\n********* MENU *********");
        System.out.println("1 - Hiển thị thông tin phim");
        System.out.println("2 - Tìm kiếm phim theo tiêu đề");
        System.out.println("3 - Thoát\n");
    }
}
