package com.example.bt_driver.controller;

import com.example.bt_driver.entity.Driver;
import com.example.bt_driver.model.BuslineModel;
import com.example.bt_driver.model.DriverAssignmentModel;
import com.example.bt_driver.model.request.DriverCreateRequest;
import com.example.bt_driver.service.BuslineService;
import com.example.bt_driver.service.DriverAssignmentService;
import com.example.bt_driver.service.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/assignments")
public class DriverAssignmentController {

    DriverAssignmentService driverAssignmentService;
    DriverService driverService;
    BuslineService buslineService;

    @GetMapping
    public String getAllDriverAssignment(Model model) {
        List<DriverAssignmentModel> driverAssignmentModels = driverAssignmentService.getAllDriverAssignment();
        model.addAttribute("danhSachDriverAssignment", driverAssignmentModels);
        return "driver-assignment-list";
    }

    @GetMapping("/create-form")
    public String forwardToCreateForm(Model model, DriverAssignmentModel driverAssignmentModel) {
        getList(model);
        model.addAttribute("themluotphancong", driverAssignmentModel);
        return "create-assignment";
    }

    @PostMapping
    public String createNewDriverAssignment(@ModelAttribute("themluotphancong") @Valid DriverAssignmentModel driverAssignmentModel, Errors errors, Model model) {
        if (null != errors && errors.getErrorCount() > 0) {
            getList(model);
            return "create-assignment";
        } else {
            driverAssignmentService.createNewDriverAssignment(driverAssignmentModel);
            return "redirect:/assignments";
        }
    }



    @GetMapping("/update/{id}")
    public String forwardToEditForm(@PathVariable int id, Model model) {
        DriverAssignmentModel driverAssignmentModel = driverAssignmentService.findDriverAssignmentById(id);
        getList(model);
        model.addAttribute("driverAssignmentCapNhatMoi", driverAssignmentModel);
        return "edit-assignment";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("driverAssignmentCapNhatMoi") @Valid DriverAssignmentModel driverAssignmentModel, Errors errors, Model model) {
        if (null != errors && errors.getErrorCount() > 0) {
            getList(model);
            return "edit-assignment";
        } else {
            driverAssignmentService.update(driverAssignmentModel);
            return "redirect:/assignments";
        }

    }
    private void getList(Model model) {
        List<Driver> driverCreateRequests = driverService.getAllDriver();
        List<BuslineModel> buslineModels = buslineService.getAllBusLine();

        model.addAttribute("danhSachDriver", driverCreateRequests);
        model.addAttribute("danhSachBusline", buslineModels);
    }
}



