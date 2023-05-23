package com.example.bt_driver.service;

import com.example.bt_driver.entity.Busline;
import com.example.bt_driver.model.BuslineModel;
import com.example.bt_driver.model.DriverModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BuslineService {
    ObjectMapper objectMapper;
    List<Busline> buslines = new ArrayList<>();
    private static int AUTO_ID = 1;


    public List<BuslineModel> getAllBusLine() {
        List<BuslineModel> result = new ArrayList<>();
        for (Busline b : buslines) {
            BuslineModel buslineModel = objectMapper.convertValue(b, BuslineModel.class);
            result.add(buslineModel);
        }
        return result;
    }

    public void saveBusLine(BuslineModel buslineModel) {
        Busline busline = objectMapper.convertValue(buslineModel, Busline.class);
        busline.setId(AUTO_ID);
        buslines.add(busline);
        AUTO_ID++;

    }

    public void delete(int id) {
        buslines.removeIf(a -> a.getId() == id);
    }

    public BuslineModel findById(int id) {
        Optional<Busline> buslineOptional = buslines
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst();  // lay thang dau tien
        if (buslineOptional.isEmpty()) {
            return null;
        }
        Busline busline = buslineOptional.get();
        return objectMapper.convertValue(busline, BuslineModel.class);

    }

    public void updateBusline(BuslineModel buslineModel) {
        buslines.forEach(s -> {
            if (s.getId() != buslineModel.getId()) {
                return;
            }
            s.setId(buslineModel.getId());
            s.setDistance(buslineModel.getDistance());
            s.setStopover(buslineModel.getStopover());
        });
    }
}
