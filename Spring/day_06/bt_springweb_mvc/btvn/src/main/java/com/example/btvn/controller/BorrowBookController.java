package com.example.btvn.controller;

import com.example.btvn.entity.BorrowBook;
import com.example.btvn.service.BorrowBookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/borrowBooks")
public class BorrowBookController {
    BorrowBookService borrowBookService;

    @GetMapping
    public String getAllBorrow(Model model) {
        List<BorrowBook> borrowBooks = borrowBookService.getAllBorrows();
        model.addAttribute("danhSachMuonBook", borrowBooks);
        return "borrowBook-list";
    }
}

