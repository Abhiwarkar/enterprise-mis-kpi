package com.company.mis.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentResponse {

    private Long id;
    private String deptCode;
    private String deptName;
    private Boolean active;
}
