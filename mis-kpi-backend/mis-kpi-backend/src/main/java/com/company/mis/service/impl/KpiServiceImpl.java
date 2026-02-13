package com.company.mis.service.impl;

import com.company.mis.dto.KpiRequest;
import com.company.mis.entity.Department;
import com.company.mis.entity.KpiResult;
import com.company.mis.repository.DepartmentRepository;
import com.company.mis.repository.KpiResultRepository;
import com.company.mis.service.KpiService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KpiServiceImpl implements KpiService {

    private final KpiResultRepository repo;
    private final DepartmentRepository departmentRepository;

    public KpiServiceImpl(KpiResultRepository repo,
                          DepartmentRepository departmentRepository) {
        this.repo = repo;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void saveKpi(KpiRequest request) {

        // 1️⃣ Department fetch
        Department department = departmentRepository
                .findByDeptCode(request.getDeptCode())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        String month = request.getMonth();
        Integer target = request.getTargetValue();
        Integer actual = request.getActualValue();


        Optional<KpiResult> existing =
                repo.findByDepartmentAndMonth(department, month);

        KpiResult result;

        if (existing.isPresent()) {
            // update same dept + same month
            result = existing.get();
            result.setTarget(Double.valueOf(target));
            result.setActual(Double.valueOf(actual));
        } else {
            // new row for new dept or new month
            result = new KpiResult();
            result.setDepartment(department);
            result.setMonth(month);
            result.setTarget(Double.valueOf(target));
            result.setActual(Double.valueOf(actual));
        }

        // optional: derived fields
        double variance = actual - target;
        result.setVariance(variance);
        result.setVariancePercent((variance / target) * 100);
        result.setStatus(actual >= target ? "Achieved" : "Not Achieved");

        repo.save(result);
    }
}
