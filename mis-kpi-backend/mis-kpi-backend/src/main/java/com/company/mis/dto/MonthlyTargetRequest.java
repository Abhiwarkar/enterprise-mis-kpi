package com.company.mis.dto;

import lombok.Data;

@Data
public class MonthlyTargetRequest {
    private String month;
    private Double targetValue;
    private Long departmentId;
}
