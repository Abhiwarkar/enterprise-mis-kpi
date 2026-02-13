package com.company.mis.controller;

import com.company.mis.service.impl.KpiCalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kpi-engine")
@RequiredArgsConstructor
public class KpiEngineController {

    private final KpiCalculationService calculationService;

    @PostMapping("/run")
    public String run(@RequestParam String month) {
        calculationService.calculate(month);
        return "KPI calculation completed for " + month;
    }
}
