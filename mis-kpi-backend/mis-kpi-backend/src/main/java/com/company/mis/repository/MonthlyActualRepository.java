package com.company.mis.repository;

import com.company.mis.entity.Department;
import com.company.mis.entity.MonthlyActual;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MonthlyActualRepository
        extends JpaRepository<MonthlyActual, Long> {

    List<MonthlyActual> findByMonth(String month);

    Optional<MonthlyActual> findByDepartmentAndMonth(
            Department department,
            String month
    );
}
