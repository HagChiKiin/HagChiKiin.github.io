package com.example.bt_driver.service;

import com.example.bt_driver.entity.Busline;
import com.example.bt_driver.model.request.BuslineCreateRequest;
import com.example.bt_driver.model.request.BuslineUpdateRequest;
import com.example.bt_driver.model.responce.BuslineResponce;
import com.example.bt_driver.validation.ObjectNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BuslineService {
    ObjectMapper objectMapper;
    List<Busline> buslines;
    private static int AUTO_ID = 1;


    public List<Busline> getAllBusLine() {
        return buslines;
    }

    public void saveBusLine(BuslineCreateRequest buslineCreateRequest) {
        Busline busline = objectMapper.convertValue(buslineCreateRequest, Busline.class);
        busline.setId(AUTO_ID);
        buslines.add(busline);
        AUTO_ID++;

    }

    public void delete(int id) {
        buslines.removeIf(a -> a.getId() == id);
    }

    public BuslineUpdateRequest findById(Integer id) {
        Optional<Busline> buslineOptional = buslines
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        if (buslineOptional.isEmpty()) {
            throw new ObjectNotFoundException("Không tìm thấy tuyến mang mã " + id);
        }
        Busline busline = buslineOptional.get();
        return objectMapper.convertValue(busline, BuslineUpdateRequest.class);

    }

    public void updateBusline(@Valid BuslineUpdateRequest buslineUpdateRequest) {
        buslines.forEach(s -> {
            if (s.getId() != buslineUpdateRequest.getId()) {
                return;
            }
            s.setId(buslineUpdateRequest.getId());
            s.setName(buslineUpdateRequest.getName());
            s.setDistance(buslineUpdateRequest.getDistance());
            s.setStopover(buslineUpdateRequest.getStopover());
        });
    }

    public BuslineResponce findByIdVer2(Integer id) {
        Optional<Busline> buslineOptional = buslines.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        if (buslineOptional.isEmpty()) {
            throw new ObjectNotFoundException("Không tìm thấy tuyến xe mang mã " + id);
        }
        Busline busline = buslineOptional.get();
        return objectMapper.convertValue(busline, BuslineResponce.class);
    }
}
