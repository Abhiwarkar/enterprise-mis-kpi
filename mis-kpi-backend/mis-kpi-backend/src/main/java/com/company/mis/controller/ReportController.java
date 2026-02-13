package com.company.mis.controller;

import com.company.mis.dto.KpiResultResponse;
import com.company.mis.service.ReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "http://localhost:5173")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public List<KpiResultResponse> getReports() {
        return reportService.getReports();
    }
}
