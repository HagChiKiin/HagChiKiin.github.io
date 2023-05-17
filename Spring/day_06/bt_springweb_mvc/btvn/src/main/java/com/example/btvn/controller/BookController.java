package com.example.btvn.controller;

import com.example.btvn.dto.ReaderTypeDto;
import com.example.btvn.dto.SpecializationDto;
import com.example.btvn.entity.Book;
import com.example.btvn.service.BookService;
import com.example.btvn.statics.ReaderType;
import com.example.btvn.statics.Specialization;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

@Controller
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {

    BookService bookService;
    @GetMapping
    public String getBook(Model model) {
        List<Book> books = bookService.getAlBook();
        model.addAttribute("danhSachBook", books);
        return "book-list";
    }

    @GetMapping("/create-form")
    public String forwardToCreateForm( Model model ,Book book  ) {
        List<Specialization> specializations = Arrays.asList(Specialization.values());
        model.addAttribute("dsChuyenNganh",specializations);
        model.addAttribute("bookTaoMoi", book);
        return "create-book";
    }
    @PostMapping
    public String createNewBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }
    @GetMapping("/{id}/delete")
    public String deleteBook(@PathVariable int id ){
        bookService.delete(id);
        return "redirect:/books";
    }
    @GetMapping("/{id}/edit")
    public String forwardToEditForm(@PathVariable int id, Model model){
        Book book = bookService.findById(id);
        List<Specialization> specializations = Arrays.asList(Specialization.values());
        model.addAttribute("dsChuyenNganh",specializations);
        model.addAttribute("bookCapNhatMoi",book);
        return "edit-book";
    }
    @PostMapping("/update")
    public String updateBook(@ModelAttribute("book") Book book){
        bookService.updateBook(book);
        return "redirect:/books";
    }
}
