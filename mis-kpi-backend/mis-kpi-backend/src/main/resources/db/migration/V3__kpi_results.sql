CREATE TABLE kpi_results (
    id BIGSERIAL PRIMARY KEY,
    month VARCHAR(20) NOT NULL,
    variance DOUBLE PRECISION,
    variance_percent DOUBLE PRECISION,
    status VARCHAR(20),
    department_id BIGINT NOT NULL,
    CONSTRAINT fk_kpi_dept FOREIGN KEY (department_id)
        REFERENCES departments(id)
        ON DELETE CASCADE
);
