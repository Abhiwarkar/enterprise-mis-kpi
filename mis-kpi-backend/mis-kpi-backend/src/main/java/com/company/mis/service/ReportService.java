package com.company.mis.service;

import com.company.mis.dto.KpiResultResponse;
import java.util.List;

public interface ReportService {

    List<KpiResultResponse> getReports();
}
