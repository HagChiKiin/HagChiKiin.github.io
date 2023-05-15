package com.example.btvn.service;

import com.example.btvn.entity.Reader;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ReaderManagement {
    private List<Reader> readers;

    public ReaderManagement() {
        this.readers = new ArrayList<>();

    }

    public void inputInfo() {
        System.out.println("Bạn muốn nhập cho bao nhiêu bạn đọc: ");
        int readerNumber;
        do {
            try {
                readerNumber = new Scanner(System.in).nextInt();
                if (readerNumber > 0) {
                    break;
                }
                System.out.println("Số lượng bạn đọc nhập vào phải lơn hơn 0, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Vui lòng nhập số: ");
            }
        } while (true);

        for (int i = 0; i < readerNumber; i++) {
            Reader reader = new Reader();
            reader.inputInfo();
            readers.add(reader);
        }
        showSubject();
    }

    private void showSubject() {
        readers.forEach(System.out::println);
    }

    public Reader findById(int id) {
        for (Reader a : readers ) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public boolean isEmptyReader() {
        return this.readers.isEmpty();
    }
}

