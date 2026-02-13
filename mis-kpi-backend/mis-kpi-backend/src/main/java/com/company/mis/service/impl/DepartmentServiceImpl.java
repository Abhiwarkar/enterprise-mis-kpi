package com.company.mis.service.impl;

import com.company.mis.dto.DepartmentRequest;
import com.company.mis.dto.DepartmentResponse;
import com.company.mis.entity.Department;
import com.company.mis.repository.DepartmentRepository;
import com.company.mis.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponse createDepartment(DepartmentRequest request) {
        Department dept = Department.builder()
                .deptCode(request.getDeptCode())
                .deptName(request.getDeptName())
                .active(true)
                .build();

        Department saved = departmentRepository.save(dept);

        return DepartmentResponse.builder()
                .id(saved.getId())
                .deptCode(saved.getDeptCode())
                .deptName(saved.getDeptName())
                .active(saved.getActive())
                .build();
    }

    @Override
    public List<DepartmentResponse> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(d -> DepartmentResponse.builder()
                        .id(d.getId())
                        .deptCode(d.getDeptCode())
                        .deptName(d.getDeptName())
                        .active(d.getActive())
                        .build())
                .toList();
    }
}
