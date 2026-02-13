package com.company.mis.repository;

import com.company.mis.entity.Department;
import com.company.mis.entity.KpiResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KpiResultRepository
        extends JpaRepository<KpiResult, Long> {

    Optional<KpiResult> findByDepartmentAndMonth(
            Department department,
            String month
    );
}
