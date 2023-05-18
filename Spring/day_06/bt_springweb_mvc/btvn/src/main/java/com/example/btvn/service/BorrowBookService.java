package com.example.btvn.service;

import com.example.btvn.model.BorrowBookModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowBookService {

    private static List<BorrowBookModel> borrowBookModels = new ArrayList<>();
    private static int AUTO_ID = 1;



    public List<BorrowBookModel> getAllBorrows() {
        return borrowBookModels;
    }

}
