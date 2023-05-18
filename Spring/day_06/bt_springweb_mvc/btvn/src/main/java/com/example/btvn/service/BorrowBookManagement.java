package com.example.btvn.service;

import com.example.btvn.model.BookModel;
import com.example.btvn.model.BorrowBookModel;
import com.example.btvn.model.BorrowBookDetailsModel;
import com.example.btvn.model.ReaderModel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BorrowBookManagement {
    private List<BorrowBookModel> borrowBookModels;
    private ReaderManagement readerManagement;
    private BookManagement bookManagement;

    public BorrowBookManagement(ReaderManagement readerManagement,BookManagement bookManagement ) {
        this.borrowBookModels = new ArrayList<>();
        this.bookManagement = bookManagement;
        this.readerManagement = readerManagement;
    }

    public void logBorrowBook() {
        if(bookManagement.isEmptyBook() || readerManagement.isEmptyReader() ){
            System.out.println("Cần phải nhập danh sách bạn đọc và đầu sách mới trước khi lập bảng Quản lý mượn sách");
            return;
        }
        System.out.println("Bạn muốn lập bảng quản lý mượn sách cho bao nhiêu bạn đọc");
        int readerNumber;
        do {
            try {
                readerNumber = new Scanner(System.in).nextInt();
                if (readerNumber > 0) {
                    break;
                }
                System.out.println("Số lượng công nhân nhập vào phải lơn hơn 0, nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Vui lòng nhập số: ");
            }
        } while (true);
        for (int i = 1; i <= readerNumber; i++) {
            System.out.println("Nhập id của bạn đọc thứ "+i+"mà bạn muốn lập bảng QL");
            int readerId;
            ReaderModel readerModel;
            do{
                try{
                    readerId = new Scanner(System.in).nextInt();
                    readerModel = readerManagement.findById(readerId);
                    if(readerModel !=null){
                        break;
                    }
                    System.out.println("ID của bạn đọc không tồn tại trong hệ thống, vui lòng nhập lại: ");
                }catch (InputMismatchException ex){
                    System.out.println("Vui lòng nhập số ");
                }
            }while (true);

            System.out.println("Bạn đọc này đã mượn bao nhiêu đầu sách");
            int bookNumber;
            do {
                try {
                    bookNumber = new Scanner(System.in).nextInt();
                    if (bookNumber > 0 && bookNumber <= 5) {
                        break;
                    }
                    System.out.println("Số đầu sách nhập vào phải lơn hơn 0 và không vượt quá 5, vui lòng nhập lại: ");
                } catch (InputMismatchException ex) {
                    System.out.println("Vui lòng nhập số: ");
                }
            } while (true);

            List<BorrowBookDetailsModel> borrowBookDetailModels = new ArrayList<>();
            for (int j = 1; j <= bookNumber; j++) {
                System.out.println("Nhập mã id của đầu sách "+j+" mà bạn đọc này đã mượn");
                int bookId;
                BookModel book;
                do {
                    try {
                        bookId = new Scanner(System.in).nextInt();
                        book = bookManagement.findById(bookId);
                        if (book != null) {
                            break;
                        }
                        System.out.println("ID của đầu sách không tồn tại trong hệ thống, vui lòng nhập lại: ");
                    } catch (InputMismatchException ex) {
                        System.out.println("Vui lòng nhập số: ");
                    }
                } while (true);

                System.out.println("Bạn đọc này mượn đầu sách đó bao nhiêu cuốn");
                int totalBook;
                do {
                    try {
                        totalBook = new Scanner(System.in).nextInt();
                        if (totalBook > 0 && totalBook <= 3) {
                            break;
                        }
                        System.out.println("Số cuốn sách nhập vào phải lơn hơn 0 và không vượt quá 3, vui lòng nhập lại: ");
                    } catch (InputMismatchException ex) {
                        System.out.println("Vui lòng nhập số: ");
                    }
                } while (true);

                BorrowBookDetailsModel borrowBookDetail = new BorrowBookDetailsModel(book,totalBook );
                borrowBookDetailModels.add(borrowBookDetail);
            }

            BorrowBookModel borrowBookModel = new BorrowBookModel(readerModel, borrowBookDetailModels);
            borrowBookModels.add(borrowBookModel);
        }
        showInfo();
    }

    private void showInfo() {
        borrowBookModels.forEach(System.out::println);
    }

}
