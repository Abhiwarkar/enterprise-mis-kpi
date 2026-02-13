package com.company.mis.controller;

import com.company.mis.dto.MonthlyActualRequest;
import com.company.mis.service.ActualService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/actuals")
@RequiredArgsConstructor
public class ActualController {

    private final ActualService actualService;

    @PostMapping
    public void save(@RequestBody MonthlyActualRequest request) {
        actualService.saveActual(request);
    }
}
