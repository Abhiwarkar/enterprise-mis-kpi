package com.company.mis.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "monthly_actuals",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"department_id", "month"})
        }
)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class MonthlyActual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String month;

    private Double actualValue;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
