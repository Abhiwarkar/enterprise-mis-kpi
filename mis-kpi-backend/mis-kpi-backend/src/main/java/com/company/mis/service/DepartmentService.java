package com.company.mis.service;

import com.company.mis.dto.DepartmentRequest;
import com.company.mis.dto.DepartmentResponse;

import java.util.List;

public interface DepartmentService {

    DepartmentResponse createDepartment(DepartmentRequest request);

    List<DepartmentResponse> getAllDepartments();
}
