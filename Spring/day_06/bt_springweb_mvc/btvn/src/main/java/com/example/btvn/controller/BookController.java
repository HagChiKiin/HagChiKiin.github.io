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
import java.util.List;

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
    public String forwardToCreateForm(Model model) {
        Book book = new Book();
        List<SpecializationDto> specializationDtos = new ArrayList<>();
        specializationDtos.add(new SpecializationDto(Specialization.KHOA_HOC_TU_NHIEN.id, Specialization.KHOA_HOC_TU_NHIEN.name));
        specializationDtos.add(new SpecializationDto(Specialization.VAN_HOC_NGHE_THUAT.id, Specialization.VAN_HOC_NGHE_THUAT.name));
        specializationDtos.add(new SpecializationDto(Specialization.DIEN_TU_VIEN_THONG.id, Specialization.DIEN_TU_VIEN_THONG.name));
        specializationDtos.add(new SpecializationDto(Specialization.CONG_NGHE_THONG_TIN.id, Specialization.CONG_NGHE_THONG_TIN.name));
        model.addAttribute("danhSachLoaiSach" , specializationDtos);
        model.addAttribute("bookTaoMoi", book);

        return "create-book";
    }
    @PostMapping
    public String createNewBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }
    @GetMapping("/{id}/delete")
    public String deleteBook(@PathVariable("id") String id){
        bookService.delete(id);
        return "redirect:/books";
    }
    @GetMapping("/{id}/edit")
    public String forwardToEditForm(@PathVariable("id") String id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("bookCapNhatMoi",book);
        return "edit-book";
    }
    @PostMapping("/update")
    public String updateBook(@ModelAttribute("book") Book book){
        bookService.updateBook(book);
        return "redirect:/books";
    }
}
