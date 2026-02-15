# MIS KPI Monitoring Backend

Enterprise MIS & KPI Monitoring System built using Spring Boot 3.

---

## 🚀 Tech Stack

- Java 17
- Spring Boot 3.2
- Spring Data JPA (Hibernate)
- Flyway (Database Migration)
- MySQL 8
- Swagger (OpenAPI)
- Maven

---

🏢 Enterprise MIS & KPI Monitoring Backend

This project is a backend system designed to monitor, evaluate, and report Key Performance Indicators (KPIs) across different departments in an organization. It enables management to track monthly targets, actual performance, and KPI status in a structured and automated way.

The system is built using Spring Boot 3, JPA (Hibernate), Flyway, and MySQL 8, following industry-level architecture and best practices.

🎯 Purpose of the Project

In many organizations:

Departments set monthly targets

Actual performance data is collected

Management manually compares results in Excel

Reports are prepared manually

This project automates that entire workflow.

It provides:

Target vs Actual comparison

KPI calculation engine

Monthly reporting

Centralized monitoring dashboard APIs


## 📂 Project Structure

src/main/java/com.company.mis
controller/
service/
repository/
entity/
dto/
exception/
security/
config/

src/main/resources
application.yml
db/migration


---

## 🗄 Database Migration

Database schema is managed using **Flyway**.

Migration scripts are located at:

src/main/resources/db/migration


- V1__init_schema.sql
- V2__targets_actuals.sql
- V3__kpi_results.sql

Flyway runs automatically on application startup.

---

## ⚙️ Run Application

```bash
mvn clean install
mvn spring-boot:run
🧪 Run Tests
mvn test
🌍 API Endpoints
/api/departments

/api/kpi/status

/api/reports/monthly

/api/health

Swagger UI:

http://localhost:8080/swagger-ui.html
