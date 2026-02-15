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
- JWT Security
- Maven

---

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
