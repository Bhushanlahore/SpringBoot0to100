package com.module3.cms.repository;

import com.module3.cms.entity.AdmissionRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRecordsRepository extends JpaRepository<AdmissionRecords, Long> {
}