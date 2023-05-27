package com.example.bt_driver.service;

import com.example.bt_driver.entity.Busline;
import com.example.bt_driver.entity.Driver;
import com.example.bt_driver.entity.DriverAssignment;
import com.example.bt_driver.model.BuslineModel;
import com.example.bt_driver.model.DriverAssignmentModel;
import com.example.bt_driver.model.request.DriverCreateRequest;
import com.example.bt_driver.model.request.DriverUpdateRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DriverAssignmentService {
    ObjectMapper objectMapper;
    DriverService driverService;
    BuslineService buslineService;

    private static List<DriverAssignment> driverAssignments = new ArrayList<>();
    private static int AUTO_ID = 1;

    public List<DriverAssignmentModel> getAllDriverAssignment() {
        List<DriverAssignmentModel> rs = new ArrayList<>();
        driverAssignments.forEach(s -> {
            DriverAssignmentModel driverAssignmentModel = DriverAssignmentModel.builder()
                    .id(s.getId())
                    .driverId(s.getDriver().getId())
                    .driverName(s.getDriver().getName())
                    .buslineId(s.getBusline().getId())
                    .buslineName(s.getBusline().getName())
                    .quantity(s.getQuantity())
                    .build();
            rs.add(driverAssignmentModel);
        });
        return rs;
    }

    public void createNewDriverAssignment(DriverAssignmentModel driverAssignmentModel) {
        if (driverAssignmentModel == null) {
            return;
        }
        Integer idDriver = driverAssignmentModel.getDriverId();
        DriverUpdateRequest driverCreateRequest = driverService.findById(idDriver);
        Driver driver = objectMapper.convertValue(driverCreateRequest, Driver.class);
        if(driver == null){
            return;
        }
        Integer idBusline = driverAssignmentModel.getBuslineId();
        BuslineModel buslineModel = buslineService.findById(idBusline);
        Busline busline = objectMapper.convertValue(buslineModel, Busline.class);
        if(busline == null){
            return;
        }
        DriverAssignment driverAssignment = DriverAssignment.builder()
                .driver(driver)
                .busline(busline)
                .quantity(driverAssignmentModel.getQuantity())
                .build();
        driverAssignment.setId(AUTO_ID);
        AUTO_ID++;
        driverAssignments.add(driverAssignment);
    }
    public DriverAssignmentModel findDriverAssignmentById(int id) {

        for (DriverAssignment d : driverAssignments) {
            if (d.getId() == id) {
                return DriverAssignmentModel.builder()
                        .id(d.getId())
                        .driverId(d.getDriver().getId())
                        .driverName(d.getDriver().getName())
                        .buslineId(d.getBusline().getId())
                        .buslineName(d.getBusline().getName())
                        .quantity(d.getQuantity())
                        .build();
            }
        }
        return null;

    }

    public void update(DriverAssignmentModel driverAssignmentModel) {
        driverAssignments.forEach(s -> {
            if (s.getId() != driverAssignmentModel.getId()) {
                return;
            }
            DriverUpdateRequest driverCreateRequest = driverService.findById(driverAssignmentModel.getDriverId());
            Driver driver = objectMapper.convertValue(driverCreateRequest, Driver.class);

            BuslineModel buslineModel = buslineService.findById(driverAssignmentModel.getDriverId());
            Busline busline = objectMapper.convertValue(buslineModel, Busline.class);

            s.setDriver(driver);
            s.setBusline(busline);
            s.setQuantity(driverAssignmentModel.getQuantity());
        });
    }
}
