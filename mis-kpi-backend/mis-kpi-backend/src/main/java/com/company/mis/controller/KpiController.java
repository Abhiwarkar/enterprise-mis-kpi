package com.company.mis.controller;

import com.company.mis.dto.KpiRequest;
import com.company.mis.service.KpiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kpi")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class KpiController {

    private final KpiService kpiService;

    @PostMapping
    public String saveKpi(@RequestBody KpiRequest request) {
        kpiService.saveKpi(request);
        return "KPI saved successfully";
    }
}

