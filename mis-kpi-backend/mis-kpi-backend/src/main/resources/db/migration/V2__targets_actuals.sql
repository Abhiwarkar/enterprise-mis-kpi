CREATE TABLE monthly_targets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    month VARCHAR(20),
    target_value DOUBLE,
    department_id BIGINT,
    CONSTRAINT fk_target_dept FOREIGN KEY (department_id)
        REFERENCES departments(id)
);

CREATE TABLE monthly_actuals (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    month VARCHAR(20),
    actual_value DOUBLE,
    department_id BIGINT,
    CONSTRAINT fk_actual_dept FOREIGN KEY (department_id)
        REFERENCES departments(id)
);