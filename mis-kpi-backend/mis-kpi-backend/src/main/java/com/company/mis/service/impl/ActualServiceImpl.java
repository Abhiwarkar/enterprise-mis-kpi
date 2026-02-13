package com.company.mis.service.impl;

import com.company.mis.dto.MonthlyActualRequest;
import com.company.mis.entity.Department;
import com.company.mis.entity.MonthlyActual;
import com.company.mis.repository.DepartmentRepository;
import com.company.mis.repository.MonthlyActualRepository;
import com.company.mis.service.ActualService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActualServiceImpl implements ActualService {

    private final MonthlyActualRepository actualRepo;
    private final DepartmentRepository deptRepo;
    private final KpiCalculationService kpiCalculationService;

    @Override
    public void saveActual(MonthlyActualRequest request) {

        Department dept = deptRepo
                .findById(request.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        MonthlyActual actual = actualRepo
                .findByDepartmentAndMonth(dept, request.getMonth())
                .orElse(new MonthlyActual());

        actual.setDepartment(dept);
        actual.setMonth(request.getMonth());
        actual.setActualValue(request.getActualValue());

        actualRepo.save(actual);


        kpiCalculationService.calculate(request.getMonth());
    }
}
