package com.example.bt_driver.service;

import com.example.bt_driver.entity.Driver;
import com.example.bt_driver.model.DriverModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DriverService {

    ObjectMapper objectMapper;
    List<Driver> drivers = new ArrayList<>();
    private static int AUTO_ID = 1;


    public List<DriverModel> getAllDriver() {
        List<DriverModel> result = new ArrayList<>();
        for (Driver d : drivers) {
            DriverModel driverModel = objectMapper.convertValue(d, DriverModel.class);
            result.add(driverModel);
        }
        return result;
    }
    public void saveDriver(DriverModel driverModel) {
        Driver driver = objectMapper.convertValue(driverModel, Driver.class);
        driver.setId(AUTO_ID);
        drivers.add(driver);
        AUTO_ID++;

    }

    public void delete(int id) {
        drivers.removeIf(a->a.getId() == id);
    }

    public DriverModel findById(int id) {
        for (Driver driver : drivers) {
            if (driver.getId() == id) return objectMapper.convertValue(driver, DriverModel.class);
        }
        return null;

    }

    public void updateDriver(DriverModel driverModel) {
        drivers.forEach(s->{
            if(s.getId() != driverModel.getId()){
                return;
            }
            s.setId(driverModel.getId());
            s.setName(driverModel.getName());
            s.setAddress(driverModel.getAddress());
            s.setPhone(driverModel.getPhone());
            s.setLevel(driverModel.getLevel());

        });
    }
}
