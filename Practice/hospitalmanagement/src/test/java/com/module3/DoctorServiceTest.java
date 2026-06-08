package com.module3;

import com.module3.entity.Appointment;
import com.module3.repository.DoctorRepository;
import com.module3.service.AppointmentService;
import com.module3.service.DoctorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class DoctorServiceTest {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testDoctorAppointsments(){

        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025, 11, 1, 14, 0, 0))
                .reason("Cancer")
                .build();

        Appointment appointment1 = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, 11, 1, 14, 0, 0))
                .reason("Cancer")
                .build();

        Appointment appointment2 = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2024, 11, 1, 14, 0, 0))
                .reason("Cancer")
                .build();

        var updatedAppointment = appointmentService.createANewAppointment(appointment, 1L, 2L);
        var updatedAppointment1 = appointmentService.createANewAppointment(appointment, 1L, 2L);
        var updatedAppointment2 = appointmentService.createANewAppointment(appointment, 1L, 2L);

        System.out.println(updatedAppointment);
        System.out.println(updatedAppointment1);
        System.out.println(updatedAppointment2);

        System.out.println(doctorService.findDoctorsAppointments(2L));
    }
}
