CREATE TABLE monthly_targets (
    id BIGSERIAL PRIMARY KEY,
    month VARCHAR(20) NOT NULL,
    target_value DOUBLE PRECISION NOT NULL,
    department_id BIGINT NOT NULL,
    CONSTRAINT fk_target_dept FOREIGN KEY (department_id)
        REFERENCES departments(id)
        ON DELETE CASCADE
);

CREATE TABLE monthly_actuals (
    id BIGSERIAL PRIMARY KEY,
    month VARCHAR(20) NOT NULL,
    actual_value DOUBLE PRECISION NOT NULL,
    department_id BIGINT NOT NULL,
    CONSTRAINT fk_actual_dept FOREIGN KEY (department_id)
        REFERENCES departments(id)
        ON DELETE CASCADE
);