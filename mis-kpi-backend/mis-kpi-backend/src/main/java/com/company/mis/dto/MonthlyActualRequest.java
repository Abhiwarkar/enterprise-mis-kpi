package com.company.mis.dto;

import lombok.Data;

@Data
public class MonthlyActualRequest {
    private String month;
    private Double actualValue;
    private Long departmentId;
}
