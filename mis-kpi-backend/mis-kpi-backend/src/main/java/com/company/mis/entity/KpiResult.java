package com.company.mis.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "kpi_results",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"department_id", "month"})
        })
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class KpiResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String month;
    private Double target;
    private Double actual;
    private Double variance;
    private Double variancePercent;

    private String status;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
