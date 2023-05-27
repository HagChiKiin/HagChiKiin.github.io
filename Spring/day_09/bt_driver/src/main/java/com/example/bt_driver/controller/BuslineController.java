package com.example.bt_driver.controller;

import com.example.bt_driver.model.BuslineModel;
import com.example.bt_driver.service.BuslineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/bus")
public class BuslineController {

    BuslineService buslineService;
    @GetMapping
    public String getAllBusLine(Model model) {
        List<BuslineModel> buslineModels = buslineService.getAllBusLine();
        model.addAttribute("danhsachBusline", buslineModels);
        return "busline-list";
    }

    @GetMapping("/create-form")
    public String forwardToCreateForm(Model model) {
        BuslineModel buslineModels = new BuslineModel();
        model.addAttribute("buslineTaoMoi",buslineModels);
        return "create-busline";
    }
    @PostMapping
    public String createNewBusline(@ModelAttribute("buslineTaoMoi") @Valid BuslineModel buslineModels, Errors errors) {
        if (null != errors && errors.getErrorCount() > 0) {
            return "create-busline";
        } else {
            buslineService.saveBusLine(buslineModels);
            return "redirect:/bus";
        }
    }
    @GetMapping("/{id}/delete")
    public String deleteBusline(@PathVariable int id ){
        buslineService.delete(id);
        return "redirect:/bus";
    }
    @GetMapping("/{id}/edit")
    public String forwardToEditForm(@PathVariable int id, Model model){
        BuslineModel buslineModels = buslineService.findById(id);
        model.addAttribute("buslineCapNhatMoi",buslineModels);
        return "edit-busline";
    }
    @PostMapping("/update")
    public String updateBusline(@ModelAttribute("buslineCapNhatMoi") @Valid BuslineModel buslineModels , Errors errors){
        if (null != errors && errors.getErrorCount() > 0) {
            return "edit-busline";
        } else {
            buslineService.updateBusline(buslineModels);
            return "redirect:/bus";
        }
    }

    
}
