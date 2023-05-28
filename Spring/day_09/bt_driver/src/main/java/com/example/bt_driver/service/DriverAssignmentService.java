package com.example.bt_driver.service;

import com.example.bt_driver.entity.Busline;
import com.example.bt_driver.entity.Driver;
import com.example.bt_driver.entity.DriverAssignment;
import com.example.bt_driver.model.request.*;
import com.example.bt_driver.model.responce.BuslineResponce;
import com.example.bt_driver.model.responce.DriverAssignmentResponce;
import com.example.bt_driver.validation.ObjectNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DriverAssignmentService {
    ObjectMapper objectMapper;
    DriverService driverService;
    BuslineService buslineService;
     static List<DriverAssignment> driverAssignments = new ArrayList<>();
     static int AUTO_ID = 1;

    public List<DriverAssignmentCreateRequest> getAllDriverAssignment() {
        List<DriverAssignmentCreateRequest> rs =  new ArrayList<>();
        driverAssignments.forEach(s->{
            DriverAssignmentCreateRequest driverAssignmentCreateRequest = DriverAssignmentCreateRequest.builder()
                    .id(s.getId())
                    .driverId(s.getDriver().getId())
                    .driverName(s.getDriver().getName())
                    .buslineId(s.getBusline().getId())
                    .buslineName(s.getBusline().getName())
                    .quantity(s.getQuantity())
                    .date(s.getDate())
                    .build();
            rs.add(driverAssignmentCreateRequest);
        });
        return rs;
    }

    public void createNewDriverAssignment(DriverAssignmentCreateRequest driverAssignmentCreateRequest) {
        if (driverAssignmentCreateRequest == null) {
            return;
        }
        Integer idDriver = driverAssignmentCreateRequest.getDriverId();
        DriverUpdateRequest driverCreateRequest = driverService.findById(idDriver);
        Driver driver = objectMapper.convertValue(driverCreateRequest, Driver.class);
        if (driver == null) {
            return;
        }
        Integer idBusline = driverAssignmentCreateRequest.getBuslineId();
        BuslineUpdateRequest buslineCreateRequest = buslineService.findById(idBusline);
        Busline busline = objectMapper.convertValue(buslineCreateRequest, Busline.class);
        if (busline == null) {
            return;
        }
        DriverAssignment driverAssignment = DriverAssignment.builder()
                .driver(driver)
                .busline(busline)
                .quantity(driverAssignmentCreateRequest.getQuantity())
                .build();
        driverAssignment.setId(AUTO_ID);
        AUTO_ID++;
        driverAssignments.add(driverAssignment);
    }

    public DriverAssignmentCreateRequest findDriverAssignmentById(int id) {

        for (DriverAssignment d : driverAssignments) {
            if (d.getId() == id) {
                return DriverAssignmentCreateRequest.builder()
                        .id(d.getId())
                        .driverId(d.getDriver().getId())
                        .driverName(d.getDriver().getName())
                        .buslineId(d.getBusline().getId())
                        .buslineName(d.getBusline().getName())
                        .quantity(d.getQuantity())
                        .date(d.getDate())
                        .build();
            }
        }
        return null;

    }

    public void update(@Valid DriverAssignmentUpdateRequest driverAssignmentUpdateRequest) {
        driverAssignments.forEach(s -> {
            if (s.getId() != driverAssignmentUpdateRequest.getId()) {
                return;
            }
            DriverUpdateRequest driverUpdateRequest = driverService.findById(driverAssignmentUpdateRequest.getDriverId());
            Driver driver = objectMapper.convertValue(driverUpdateRequest, Driver.class);

            BuslineUpdateRequest buslineUpdateRequest = buslineService.findById(driverAssignmentUpdateRequest.getBuslineId());
            Busline busline = objectMapper.convertValue(buslineUpdateRequest, Busline.class);
//            s.setId(driverAssignmentUpdateRequest.getId());
            s.setDriver(driver);
            s.setBusline(busline);
            s.setQuantity(driverAssignmentUpdateRequest.getQuantity());
            s.setDate(driverAssignmentUpdateRequest.getDate());
        });
    }


    public DriverAssignmentResponce findByIdVer2(Integer id) {
        Optional<DriverAssignment> driverAssignmentOptional = driverAssignments.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        if (driverAssignmentOptional.isEmpty()) {
            throw new ObjectNotFoundException("Không tìm thấy lượt phân công mang mã " + id);
        }
        DriverAssignment driverAssignment = driverAssignmentOptional.get();
        return objectMapper.convertValue(driverAssignment, DriverAssignmentResponce.class);
    }
}
