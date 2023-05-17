package com.example.btvn.service;

import com.example.btvn.entity.BorrowBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowBookService {

    private static List<BorrowBook> borrowBooks = new ArrayList<>();
    private static int AUTO_ID = 1;



    public List<BorrowBook> getAllBorrows() {
        return borrowBooks;
    }

}
