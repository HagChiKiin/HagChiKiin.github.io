package com.example.btvn.service;

import com.example.btvn.model.ReaderModel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ReaderManagement {
    private List<ReaderModel> readerModels;

    public ReaderManagement() {
        this.readerModels = new ArrayList<>();

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
            ReaderModel readerModel = new ReaderModel();
            readerModel.inputInfo();
            readerModels.add(readerModel);
        }
        showSubject();
    }

    private void showSubject() {
        readerModels.forEach(System.out::println);
    }

    public ReaderModel findById(int id) {
        for (ReaderModel a : readerModels) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public boolean isEmptyReader() {
        return this.readerModels.isEmpty();
    }
}

