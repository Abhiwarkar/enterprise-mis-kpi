package com.company.mis.service.impl;

import com.company.mis.dto.MonthlyTargetRequest;
import com.company.mis.entity.Department;
import com.company.mis.entity.MonthlyTarget;
import com.company.mis.repository.DepartmentRepository;
import com.company.mis.repository.MonthlyTargetRepository;
import com.company.mis.service.TargetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TargetServiceImpl implements TargetService {

    private final MonthlyTargetRepository targetRepo;
    private final DepartmentRepository deptRepo;
    private final KpiCalculationService kpiCalculationService;

    @Override
    public void saveTarget(MonthlyTargetRequest request) {

        Department dept = deptRepo
                .findById(request.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        MonthlyTarget target = targetRepo
                .findByDepartmentAndMonth(dept, request.getMonth())
                .orElse(new MonthlyTarget());

        target.setDepartment(dept);
        target.setMonth(request.getMonth());
        target.setTargetValue(request.getTargetValue());

        targetRepo.save(target);


        kpiCalculationService.calculate(request.getMonth());
    }
}
