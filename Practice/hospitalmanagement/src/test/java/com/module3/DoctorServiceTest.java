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
    }
}
