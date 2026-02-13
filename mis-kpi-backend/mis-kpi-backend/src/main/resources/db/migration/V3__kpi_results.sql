CREATE TABLE kpi_results (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    month VARCHAR(20),
    variance DOUBLE,
    variance_percent DOUBLE,
    status VARCHAR(20),
    department_id BIGINT,
    CONSTRAINT fk_kpi_dept FOREIGN KEY (department_id)
        REFERENCES departments(id)
);
