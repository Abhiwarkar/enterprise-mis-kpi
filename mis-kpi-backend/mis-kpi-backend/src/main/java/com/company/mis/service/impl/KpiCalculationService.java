package com.company.mis.service.impl;

import com.company.mis.entity.*;
import com.company.mis.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KpiCalculationService {

    private final MonthlyTargetRepository targetRepo;
    private final MonthlyActualRepository actualRepo;
    private final KpiResultRepository resultRepo;

    public void calculate(String month) {

        targetRepo.findByMonth(month).forEach(target -> {

            MonthlyActual actual = actualRepo
                    .findByDepartmentAndMonth(
                            target.getDepartment(), month
                    )
                    .orElse(null);

            if (actual == null) return;

            double variance =
                    actual.getActualValue() - target.getTargetValue();

            double variancePct =
                    (variance / target.getTargetValue()) * 100;

            String status;
            if (actual.getActualValue() >= target.getTargetValue()) {
                status = "Achieved";
            } else if (variancePct >= -10) {
                status = "Warning";
            } else {
                status = "Critical";
            }


            KpiResult result = resultRepo
                    .findByDepartmentAndMonth(
                            target.getDepartment(), month
                    )
                    .orElse(new KpiResult());

            result.setDepartment(target.getDepartment());
            result.setMonth(month);
            result.setTarget(target.getTargetValue().doubleValue());
            result.setActual(actual.getActualValue().doubleValue());
            result.setVariance(variance);
            result.setVariancePercent(variancePct);
            result.setStatus(status);

            resultRepo.save(result);
        });
    }
}
