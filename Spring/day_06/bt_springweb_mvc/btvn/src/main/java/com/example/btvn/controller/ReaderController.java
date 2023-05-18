package com.example.btvn.controller;

import com.example.btvn.model.ReaderModel;
import com.example.btvn.service.ReaderService;
import com.example.btvn.statics.ReaderType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/readers")
public class ReaderController {

    ReaderService readerService;

    @GetMapping
    public String getReader(Model model) {
        List<ReaderModel> readerModels = readerService.getAlReader();
        model.addAttribute("danhSachReader", readerModels);
        return "reader-list";
    }

    @GetMapping("/create-form")
    public String forwardToCreateForm(Model model , ReaderModel readerModel) {
        List<ReaderType> readerTypes = Arrays.asList(ReaderType.values());
        model.addAttribute("dsBanDoc",readerTypes);
        model.addAttribute("banDocTaoMoi", readerModel);
        return "create-reader";
    }

    @PostMapping
    public String createNewReader(@ModelAttribute("reader") ReaderModel readerModel) {
        readerService.saveReader(readerModel);
        return "redirect:/readers";
    }

    @GetMapping("/{id}/delete")
    public String deleteReader(@PathVariable int id) {
        readerService.delete(id);
        return "redirect:/readers";
    }

    @GetMapping("/{id}/edit")
    public String forwardToEditForm(@PathVariable int id, Model model){
        ReaderModel readerModel = readerService.findById(id);
        List<ReaderType> readerTypes = Arrays.asList(ReaderType.values());
        model.addAttribute("dsBanDoc",readerTypes);
        model.addAttribute("banDocCapNhatMoi", readerModel);
        return "edit-reader";
    }


    @PostMapping("/update")
    public String updateReader(@ModelAttribute("reader") ReaderModel readerModel) {
        readerService.updateReader(readerModel);
        return "redirect:/readers";
    }
}
