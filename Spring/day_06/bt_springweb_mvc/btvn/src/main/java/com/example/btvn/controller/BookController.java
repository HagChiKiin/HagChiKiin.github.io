package com.example.btvn.controller;

import com.example.btvn.model.BookModel;
import com.example.btvn.service.BookService;
import com.example.btvn.statics.Specialization;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {

    BookService bookService;
    @GetMapping
    public String getBook(Model model) {
        List<BookModel> books = bookService.getAlBook();
        model.addAttribute("danhSachBook", books);
        return "book-list";
    }

    @GetMapping("/create-form")
    public String forwardToCreateForm(Model model , BookModel book  ) {
        List<Specialization> specializations = Arrays.asList(Specialization.values());
        model.addAttribute("dsChuyenNganh",specializations);
        model.addAttribute("bookTaoMoi", book);
        return "create-book";
    }
    @PostMapping
    public String createNewBook(@ModelAttribute("bookTaoMoi") @Valid  BookModel book, Errors errors, Model model) {
        if (null != errors && errors.getErrorCount() > 0) {
            List<Specialization> specializations = Arrays.asList(Specialization.values());
            model.addAttribute("dsChuyenNganh",specializations);
            return "create-book";
        } else {
            bookService.saveBook(book);
            return "redirect:/books";
        }
    }
    @GetMapping("/{id}/delete")
    public String deleteBook(@PathVariable int id ){
        bookService.delete(id);
        return "redirect:/books";
    }
    @GetMapping("/{id}/edit")
    public String forwardToEditForm(@PathVariable int id, Model model){
        BookModel book = bookService.findById(id);
        List<Specialization> specializations = Arrays.asList(Specialization.values());
        model.addAttribute("dsChuyenNganh",specializations);
        model.addAttribute("bookCapNhatMoi",book);
        return "edit-book";
    }
    @PostMapping("/update")
    public String updateBook(@ModelAttribute("bookCapNhatMoi") @Valid  BookModel book , Errors errors, Model model){
        if (null != errors && errors.getErrorCount() > 0) {
            List<Specialization> specializations = Arrays.asList(Specialization.values());
            model.addAttribute("dsChuyenNganh",specializations);
            return "edit-book";
        } else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
}
