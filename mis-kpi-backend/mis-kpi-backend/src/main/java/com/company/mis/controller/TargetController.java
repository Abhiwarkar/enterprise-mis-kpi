package com.company.mis.controller;

import com.company.mis.dto.MonthlyTargetRequest;
import com.company.mis.service.TargetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/targets")
@RequiredArgsConstructor
public class TargetController {

    private final TargetService targetService;

    @PostMapping
    public void save(@RequestBody MonthlyTargetRequest request) {
        targetService.saveTarget(request);
    }
}
