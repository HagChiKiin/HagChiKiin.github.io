package com.example.driver_security.controller;

import com.example.driver_security.entity.Driver;
import com.example.driver_security.model.request.DriverCreateRequest;
import com.example.driver_security.model.request.DriverRequest;
import com.example.driver_security.model.request.DriverUpdateRequest;
import com.example.driver_security.model.response.DriverResponce;
import com.example.driver_security.model.response.LevelResponce;
import com.example.driver_security.model.response.UserResponse;
import com.example.driver_security.security.CustomUserDetails;
import com.example.driver_security.service.DriverService;
import com.example.driver_security.service.LevelService;
import com.example.driver_security.statics.Level;
import com.example.driver_security.validation.NotFoundException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/drivers")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DriverController {

    DriverService driverService;

    LevelService levelService;

    @GetMapping
    public List<DriverResponce> getAll() {
        return driverService.getAll();
    }

    @GetMapping("/{id}")
    public DriverResponce getDetail(@PathVariable Long id) throws ClassNotFoundException {
        return driverService.getDetail(id);
    }


    @PostMapping
    public DriverResponce create(@RequestBody @Valid DriverRequest request) {
        return driverService.create(request);
    }
//
//    @GetMapping
//    public String getAllDriver(Model model, Authentication authentication) {
//        List<Driver> driver = driverService.getAllDriver();
//        List<Level> levels = Arrays.asList(Level.values());
//        model.addAttribute("dsTaiXe",levels);
//        model.addAttribute("danhSachDriver", driver);
//        model.addAttribute("driverTaoMoi", new DriverCreateRequest());
//
//        return "driver-list";
//    }


    @PostMapping
    public String createNewDriver(@ModelAttribute("driverTaoMoi") @Valid DriverCreateRequest driverCreateRequest) {
        driverService.saveDriver(driverCreateRequest);
        return "redirect:/drivers";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteDriver(@PathVariable int id) {
        driverService.delete(id);
        return "redirect:/drivers";
    }

    @GetMapping("/{id}/edit")
    public String forwardToUpdateForm(@PathVariable("id") int id, Model model) {
        DriverUpdateRequest driverUpdateRequest = driverService.findById(id);
        List<Level> levels = Arrays.asList(Level.values());
        model.addAttribute("dsTaiXe",levels);
        model.addAttribute("driverCapNhatMoi", driverUpdateRequest);
        return "edit-driver";
    }

    @PostMapping("/update")
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
