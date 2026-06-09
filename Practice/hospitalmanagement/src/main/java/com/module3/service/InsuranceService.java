package com.module3.service;

import com.module3.entity.Insurance;
import com.module3.entity.Patient;
import com.module3.repository.InsuranceRepository;
import com.module3.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance); // dirty patient

        insurance.setPatient(patient); //optional,
        return insurance;
    }

    @Transactional
    public Insurance updateInsuranceOfAPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance); // dirty patient

        insurance.setPatient(patient); //optional,
        return insurance;
    }

    @Transactional
    public Patient removeInsuranceOfAPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(null); // dirty patient

        return patient;
    }


}
