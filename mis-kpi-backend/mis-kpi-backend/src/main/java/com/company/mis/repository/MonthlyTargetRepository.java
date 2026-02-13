package com.company.mis.repository;

import com.company.mis.entity.Department;
import com.company.mis.entity.MonthlyTarget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MonthlyTargetRepository
        extends JpaRepository<MonthlyTarget, Long> {

    List<MonthlyTarget> findByMonth(String month);

    Optional<MonthlyTarget> findByDepartmentAndMonth(
            Department department,
            String month
    );
}
