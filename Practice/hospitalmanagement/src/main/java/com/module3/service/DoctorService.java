package com.module3.service;


import com.module3.entity.Doctor;
import com.module3.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Transactional
    public Doctor findDoctorsAppointments(Long id){

        return doctorRepository.findById(id).orElseThrow();

    }

}
