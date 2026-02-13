package com.company.mis.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dept_code", nullable = false, unique = true)
    private String deptCode;

    @Column(name = "dept_name", nullable = false)
    private String deptName;

    @Column(nullable = false)
    private Boolean active;
}
