package com.module3;

import com.module3.dto.BloodGroupStats;
import com.module3.dto.CPatientInfo;
import com.module3.entity.Patient;
import com.module3.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatient() {
        List<Patient> patientList = patientRepository.findAll();
        for(var p: patientList) {
            System.out.println(p);
        }
    }

    @Test
    public void testCPatientInfo(){
        List<CPatientInfo> patientList = patientRepository.getAllPatientsInfoConcrete();
        for(CPatientInfo p: patientList) {
            System.out.println(p);
        }
    }

    @Test
    public void testBloodGroupStatus(){
        List<BloodGroupStats> patientList = patientRepository.getBloodGroupStats();
        for(BloodGroupStats p: patientList) {
            System.out.println(p);
        }
    }

    @Test
    public void testUpdatePatient(){
        int rowsAffected = patientRepository.updatePatientNameWithId("Anuj Sharma", 1L);
        System.out.println(rowsAffected);
    }
}
