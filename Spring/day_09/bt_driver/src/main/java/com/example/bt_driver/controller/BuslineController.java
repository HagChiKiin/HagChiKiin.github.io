package com.example.bt_driver.controller;

import com.example.bt_driver.entity.Busline;
import com.example.bt_driver.model.request.BuslineCreateRequest;
import com.example.bt_driver.model.request.BuslineUpdateRequest;
import com.example.bt_driver.model.request.DriverCreateRequest;
import com.example.bt_driver.model.request.DriverUpdateRequest;
import com.example.bt_driver.model.responce.LevelResponce;
import com.example.bt_driver.service.BuslineService;
import com.example.bt_driver.statics.Level;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping
public class BuslineController {

    BuslineService buslineService;

    @GetMapping("/bus")
    public String getAllBusLine(Model model) {
        List<Busline> buslines = buslineService.getAllBusLine();
        model.addAttribute("danhSachBusline", buslines);
        model.addAttribute("buslineTaoMoi",new BuslineCreateRequest());
        return "busline-list";
    }

//    @GetMapping("/create-form")
//    public String forwardToCreateForm(Model model) {
//        BuslineCreateRequest buslineModels = new BuslineCreateRequest();
//        model.addAttribute("buslineTaoMoi",buslineModels);
//        return "create-busline";
//    }

    @PostMapping("/bus")
    public String createNewBusline(@ModelAttribute("buslineTaoMoi") @Valid BuslineCreateRequest buslineCreateRequest) {
        buslineService.saveBusLine(buslineCreateRequest);
        return "redirect:/bus";
    }

    @GetMapping("/bus/{id}/delete")
    public String deleteBusline(@PathVariable int id) {
        buslineService.delete(id);
        return "redirect:/bus";
    }

    @GetMapping("/bus/{id}/edit")
    public String forwardToEditForm(@PathVariable("id") int id, Model model) {
        BuslineUpdateRequest buslineUpdateRequest = buslineService.findById(id);
        model.addAttribute("buslineCapNhatMoi", buslineUpdateRequest);
        return "edit-busline";
    }

    @PostMapping("/bus/update")
    public String updateBusline(@ModelAttribute("buslineCapNhatMoi") @Valid BuslineUpdateRequest buslineUpdateRequest, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("buslineCapNhatMoi", buslineUpdateRequest);
            return "update-busline";
        }
        buslineService.updateBusline(buslineUpdateRequest);
        return "redirect:/bus";
    }

    @GetMapping("/api/bus/{id}")
    public ResponseEntity<?> getBusline(@PathVariable Integer id) {
        return ResponseEntity.ok(buslineService.findByIdVer2(id));
    }
    @PutMapping("/api/bus/{id}")
    public ResponseEntity<?> updateBusline(@PathVariable Integer id, @RequestBody @Valid BuslineUpdateRequest buslineUpdateRequest, Model model) {
        buslineUpdateRequest.setId(id);
        buslineService.updateBusline(buslineUpdateRequest);
        return ResponseEntity.ok(null);
    }

}
