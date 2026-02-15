package com.company.mis.service.impl;

import com.company.mis.dto.KpiResultResponse;
import com.company.mis.repository.KpiResultRepository;
import com.company.mis.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    private final KpiResultRepository kpiResultRepository;

    public ReportServiceImpl(KpiResultRepository kpiResultRepository) {
        this.kpiResultRepository = kpiResultRepository;
    }

    @Override

    public List<KpiResultResponse> getReports() {
        return kpiResultRepository.findAll()
                .stream()
                .filter(result -> result.getDepartment() != null)
                .map(result -> new KpiResultResponse(
                        result.getDepartment().getDeptCode(),
                        result.getMonth(),
                        result.getTarget(),
                        result.getActual(),
                        result.getVariancePercent(),
                        result.getStatus()
                ))

                .collect(Collectors.toList());
    }

}
