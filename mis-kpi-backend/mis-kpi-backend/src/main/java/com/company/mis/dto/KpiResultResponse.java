package com.company.mis.dto;

public class KpiResultResponse {

    private String deptCode;
    private String month;
    private Double targetValue;
    private Double actualValue;
    private Double achievementPct;
    private String status;

    public KpiResultResponse(
            String deptCode,
            String month,
            Double targetValue,
            Double actualValue,
            Double achievementPct,
            String status
    ) {
        this.deptCode = deptCode;
        this.month = month;
        this.targetValue = targetValue;
        this.actualValue = actualValue;
        this.achievementPct = achievementPct;
        this.status = status;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public String getMonth() {
        return month;
    }

    public Double getTargetValue() {
        return targetValue;
    }

    public Double getActualValue() {
        return actualValue;
    }

    public Double getAchievementPct() {
        return achievementPct;
    }

    public String getStatus() {
        return status;
    }
}
