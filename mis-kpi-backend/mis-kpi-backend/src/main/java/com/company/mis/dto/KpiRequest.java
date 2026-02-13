package com.company.mis.dto;

public class KpiRequest {

    private String deptCode;
    private String month;
    private Integer targetValue;
    private Integer actualValue;


    public String getDeptCode() { return deptCode; }
    public void setDeptCode(String deptCode) { this.deptCode = deptCode; }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }

    public Integer getTargetValue() { return targetValue; }
    public void setTargetValue(Integer targetValue) { this.targetValue = targetValue; }

    public Integer getActualValue() { return actualValue; }
    public void setActualValue(Integer actualValue) { this.actualValue = actualValue; }
}
