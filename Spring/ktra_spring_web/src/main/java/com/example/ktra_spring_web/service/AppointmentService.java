package com.example.ktra_spring_web.service;

import com.example.ktra_spring_web.entity.Appointment;
import com.example.ktra_spring_web.entity.User;
import com.example.ktra_spring_web.exception.NotFoundException;
import com.example.ktra_spring_web.model.request.AppointmentRequest;
import com.example.ktra_spring_web.model.response.AppointmentResponse;
import com.example.ktra_spring_web.repository.AppointmentRepository;
import com.example.ktra_spring_web.repository.UserRepository;
import com.example.ktra_spring_web.statics.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentService {

    ObjectMapper objectMapper;

    AppointmentRepository appointmentRepository;

    EmailService emailService;

    UserRepository userRepository;

    public AppointmentResponse updateAppointment(Integer id, AppointmentRequest appointmentRequest) throws NotFoundException {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("appointment not found !"));
        appointment.setStatus(appointmentRequest.getStatus());
        appointmentRepository.save(appointment);
        emailService.sendEmailConfirmAppointment(appointment);
        return objectMapper.convertValue(appointment, AppointmentResponse.class);
    }

    public AppointmentResponse createAppointment(AppointmentRequest appointmentRequest) {

    }

}
