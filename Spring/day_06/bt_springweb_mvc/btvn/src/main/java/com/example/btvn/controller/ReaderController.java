package com.example.btvn.controller;

import com.example.btvn.dto.ReaderTypeDto;
import com.example.btvn.dto.SpecializationDto;
import com.example.btvn.entity.Book;
import com.example.btvn.entity.Reader;
import com.example.btvn.service.BookService;
import com.example.btvn.service.ReaderService;
import com.example.btvn.statics.ReaderType;
import com.example.btvn.statics.Specialization;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/readers")
public class ReaderController {

    ReaderService readerService;

    @GetMapping
    public String getReader(Model model) {
        List<Reader> readers = readerService.getAlReader();
        model.addAttribute("danhSachReader", readers);
        return "reader-list";
    }

    @GetMapping("/create-form")
    public String forwardToCreateForm( Model model ,Reader reader  ) {
        List<ReaderType> readerTypes = Arrays.asList(ReaderType.values());
        model.addAttribute("dsBanDoc",readerTypes);
        model.addAttribute("banDocTaoMoi", reader);
        return "create-reader";
    }

    @PostMapping
    public String createNewReader(@ModelAttribute("reader") Reader reader) {
        readerService.saveReader(reader);
        return "redirect:/readers";
    }

    @GetMapping("/{id}/delete")
    public String deleteReader(@PathVariable int id) {
        readerService.delete(id);
        return "redirect:/readers";
    }

    @GetMapping("/{id}/edit")
    public String forwardToEditForm(@PathVariable int id, Model model){
        Reader reader = readerService.findById(id);
        List<ReaderType> readerTypes = Arrays.asList(ReaderType.values());
        model.addAttribute("dsBanDoc",readerTypes);
        model.addAttribute("banDocCapNhatMoi",reader);
        return "edit-reader";
    }


    @PostMapping("/update")
    public String updateReader(@ModelAttribute("reader") Reader reader) {
        readerService.updateReader(reader);
        return "redirect:/readers";
    }
}
