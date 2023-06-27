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

    // view
    @GetMapping
    public String getAllDriver(Model model) {
        List<DriverResponce> driver = driverService.getAll();
        List<Level> levels = Arrays.asList(Level.values());
        model.addAttribute("dsTaiXe",levels);
        model.addAttribute("danhSachDriver", driver);
        model.addAttribute("driverTaoMoi", new DriverCreateRequest());

        return "driver-list";
    }

    @PutMapping("/{id}/edit")
    public String forwardToUpdateForm(@PathVariable("id") int id, Model model) {
        DriverUpdateRequest driverUpdateRequest = driverService.findById(id);
        List<Level> levels = Arrays.asList(Level.values());
        model.addAttribute("dsTaiXe",levels);
        model.addAttribute("driverCapNhatMoi", driverUpdateRequest);
        return "edit-driver";
    }

    @PutMapping("/update")
    public String updateDriver(@ModelAttribute("driverCapNhatMoi")  Integer id, @Valid DriverUpdateRequest driverUpdateRequest,  BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Level> levels = Arrays.asList(Level.values());
            model.addAttribute("dsTaiXe",levels);
            model.addAttribute("driverCapNhatMoi", driverUpdateRequest);
            return "update-driver";
        }
        driverService.updateDriver(id,driverUpdateRequest);
        return "redirect:/drivers";
    }

    @ModelAttribute("levelData")
    public List<LevelResponce> getAllLevel() {
        return levelService.getAll();
    }

    //api

    @GetMapping("/api/v1/drivers/{id}")
    public ResponseEntity<?> getDriver(@PathVariable Integer id) {
        return ResponseEntity.ok(driverService.findByIdVer2(id));
    }
    // thêm
    @PostMapping("/api/v1/products")
    public ResponseEntity<?> create(@RequestBody @Valid DriverRequest request) {
        DriverResponce driverResponce = driverService.create(request);
        return ResponseEntity.ok(driverResponce);
    }

    @PutMapping("{id}")
    public ResponseEntity<Driver> updateStudent(@PathVariable Integer id, @RequestBody @Valid DriverUpdateRequest driverUpdateRequest, Model model) {
        driverService.updateDriver(id,driverUpdateRequest);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Driver> deleteFile(@PathVariable Integer id) {
        driverService.delete(id);
        return ResponseEntity.noContent().build();  // trả về mã 204 - no content
    }

}
