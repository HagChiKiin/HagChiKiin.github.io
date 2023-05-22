package com.example.bt_driver.controller;

import com.example.bt_driver.model.BuslineModel;
import com.example.bt_driver.model.DriverModel;
import com.example.bt_driver.service.BuslineService;
import com.example.bt_driver.service.DriverService;
import com.example.bt_driver.statics.Level;
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
@RequestMapping("/drivers")
public class DriverController {

    DriverService driverService;
    @GetMapping
    public String getAllDriver(Model model) {
        List<DriverModel> driverModels = driverService.getAllDriver();
        model.addAttribute("danhSachDriver", driverModels);
        return "driver-list";
    }

    @GetMapping("/create-form")
    public String forwardToCreateForm(Model model , DriverModel driverModel  ) {
        List<Level> levels = Arrays.asList(Level.values());
        model.addAttribute("dsTaiXe",levels);
        model.addAttribute("driverTaoMoi", driverModel);
        return "create-driver";
    }
    @PostMapping
    public String createNewDriver(@ModelAttribute("driverTaoMoi") @Valid DriverModel driverModel, Errors errors, Model model) {
        if (null != errors && errors.getErrorCount() > 0) {
            List<Level> levels = Arrays.asList(Level.values());
            model.addAttribute("dsTaiXe",levels);
            return "create-driver";
        } else {
            driverService.saveDriver(driverModel);
            return "redirect:/drivers";
        }
    }
    @GetMapping("/{id}/delete")
    public String deleteDriver(@PathVariable int id ){
        driverService.delete(id);
        return "redirect:/drivers";
    }
    @GetMapping("/{id}/edit")
    public String forwardToEditForm(@PathVariable int id, Model model){
        DriverModel driverModel = driverService.findById(id);
        List<Level> levels = Arrays.asList(Level.values());
        model.addAttribute("dsTaiXe",levels);
        model.addAttribute("driverCapNhatMoi",driverModel);
        return "edit-driver";
    }
    @PostMapping("/update")
    public String updateDriver(@ModelAttribute("driverCapNhatMoi") @Valid  DriverModel driverModel , Errors errors, Model model){
        if (null != errors && errors.getErrorCount() > 0) {
            List<Level> levels = Arrays.asList(Level.values());
            model.addAttribute("dsTaiXe",levels);
            return "edit-driver";
        } else {
            driverService.updateDriver(driverModel);
            return "redirect:/drivers";
        }
    }

    
}
