package com.example.bt_driver.controller;

import com.example.bt_driver.entity.Driver;
import com.example.bt_driver.model.request.DriverCreateRequest;
import com.example.bt_driver.model.request.DriverUpdateRequest;
import com.example.bt_driver.model.responce.LevelResponce;
import com.example.bt_driver.service.DriverService;
import com.example.bt_driver.service.LevelService;
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
public class DriverController {

    DriverService driverService;

    LevelService levelService;

    @GetMapping("/drivers")
    public String getAllDriver(Model model) {
        List<Driver> driver = driverService.getAllDriver();
        List<Level> levels = Arrays.asList(Level.values());
        model.addAttribute("dsTaiXe",levels);
        model.addAttribute("danhSachDriver", driver);
        model.addAttribute("driverTaoMoi", new DriverCreateRequest());
        return "driver-list";
    }

    //    @GetMapping("/create-form")
//    public String forwardToCreateForm(Model model , DriverCreateRequest driverCreateRequest) {
//        List<Level> levels = Arrays.asList(Level.values());
//        model.addAttribute("dsTaiXe",levels);
//        model.addAttribute("driverTaoMoi", driverCreateRequest);
//        return "create-driver";
//    }
    @PostMapping("/drivers")
    public String createNewDriver(@ModelAttribute("driverTaoMoi") @Valid DriverCreateRequest driverCreateRequest) {
        driverService.saveDriver(driverCreateRequest);
        return "redirect:/drivers";
    }

    @GetMapping("/drivers/{id}/delete")
    public String deleteDriver(@PathVariable int id) {
        driverService.delete(id);
        return "redirect:/drivers";
    }

    @GetMapping("/drivers/{id}/edit")
    public String forwardToUpdateForm(@PathVariable("id") int id, Model model) {
        DriverUpdateRequest driverUpdateRequest = driverService.findById(id);
        List<Level> levels = Arrays.asList(Level.values());
        model.addAttribute("dsTaiXe",levels);
        model.addAttribute("driverCapNhatMoi", driverUpdateRequest);
        return "edit-driver";
    }

    @PostMapping("/drivers/update")
    public String updateDriver(@ModelAttribute("driverCapNhatMoi") @Valid DriverUpdateRequest driverUpdateRequest,  BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Level> levels = Arrays.asList(Level.values());
            model.addAttribute("dsTaiXe",levels);
            model.addAttribute("driverCapNhatMoi", driverUpdateRequest);
            return "update-driver";
        }
        driverService.updateDriver(driverUpdateRequest);
        return "redirect:/drivers";
    }

    @ModelAttribute("levelData")
    public List<LevelResponce> getAllLevel() {
        return levelService.getAll();
    }

    @GetMapping("/api/drivers/{id}")
    public ResponseEntity<?> getDriver(@PathVariable Integer id) {
        return ResponseEntity.ok(driverService.findByIdVer2(id));
    }
    @PutMapping("/api/drivers/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody @Valid DriverUpdateRequest driverUpdateRequest, Model model) {
        List<Level> levels = Arrays.asList(Level.values());
        model.addAttribute("dsTaiXe",levels);
        driverUpdateRequest.setId(id);
        driverService.updateDriver(driverUpdateRequest);
        return ResponseEntity.ok(null);
    }




}
