# 🔔 Reminder & Notification Service

A smart Reminder and Notification Service built with **Java Spring Boot** that automatically sends email reminders to users at scheduled times. Features **Spring Scheduler** for automatic background job execution and **JavaMailSender** for email integration, secured with **JWT Authentication**.

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| Java 17 | Programming Language |
| Spring Boot 3.x | Backend Framework |
| Spring Security | Authentication & Authorization |
| JWT (JSON Web Token) | Secure Token Based Authentication |
| Spring Scheduler | Automatic Background Job Execution |
| JavaMailSender | Email Integration |
| Spring Data JPA | Database Operations |
| MySQL | Relational Database |
| Lombok | Reduce Boilerplate Code |
| Maven | Build Tool |
| Postman | API Testing |

## ✨ Features

- ✅ User Registration and Login with JWT Authentication
- ✅ Secure Password Encryption using BCrypt
- ✅ Create, Read, Update and Delete Reminders
- ✅ Automatic Email Notifications using Spring Scheduler
- ✅ Emails sent automatically when reminder time is reached
- ✅ Reminder marked as sent after email delivery
- ✅ Global Exception Handling with Custom Error Responses
- ✅ Protected APIs — Token Required for Access

## 📁 Project Structure

src/main/java/com/reminder/service/
├── controller/
│ ├── AuthController.java
│ └── ReminderController.java
├── service/
│ ├── UserService.java
│ ├── ReminderService.java
│ ├── EmailService.java
│ └── SchedulerService.java
├── repository/
│ ├── UserRepository.java
│ └── ReminderRepository.java
├── model/
│ ├── User.java
│ └── Reminder.java
├── dto/
│ ├── RegisterRequest.java
│ ├── LoginRequest.java
│ ├── AuthResponse.java
│ └── ReminderRequest.java
├── security/
│ ├── JwtUtil.java
│ ├── JwtFilter.java
│ └── SecurityConfig.java
└── exception/
├── ResourceNotFoundException.java
├── ErrorResponse.java
└── GlobalExceptionHandler.java

## 📋 API Endpoints

### 🔐 Authentication APIs (Public)
| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/auth/register | Register new user |
| POST | /api/auth/login | Login and get JWT token |

### 🔔 Reminder APIs (Protected)
| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/reminders | Create new reminder |
| GET | /api/reminders/user/{email} | Get reminders by user |
| GET | /api/reminders/{id} | Get reminder by ID |
| PUT | /api/reminders/{id} | Update reminder |
| DELETE | /api/reminders/{id} | Delete reminder |

## 🚀 How to Run

### Prerequisites
- Java 17
- MySQL
- Maven
- Gmail Account with App Password

### Steps

**1. Clone the repository**
```bash
git clone https://github.com/vijaypawar30/reminder-notification-service.git
```

**2. Configure application.properties**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/reminder_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.mail.username=your@gmail.com
spring.mail.password=your-app-password
```

**3. Run the application**
```bash
mvn spring-boot:run
```

**4. Test APIs using Postman**
Base URL: http://localhost:8083/api

### How JWT Authentication Works

**Step 1 — Register**
```json
POST /api/auth/register
{
    "name": "Your Name",
    "email": "your@email.com",
    "password": "yourpassword"
}
```

**Step 2 — Login and get token**
```json
POST /api/auth/login
{
    "email": "your@email.com",
    "password": "yourpassword"
}
```

**Step 3 — Use token in requests**
Authorization: Bearer <your-token>

### How Scheduler Works

Every 60 seconds →
Spring Scheduler checks database →
Finds reminders where reminderTime < now AND sent = false →
Sends email automatically →
Marks reminder as sent = true →
Repeat! ♻️

## 👨‍💻 Author

**Vijay Vishnu Pawar**

- 🎓 MCA Student at Savitribai Phule Pune University
- 💼 Java Full Stack Developer
- 🔗 LinkedIn: [linkedin.com/in/vijay-pawar-41a575380](https://linkedin.com/in/vijay-pawar-41a575380)
- 🐙 GitHub: [github.com/vijaypawar30](https://github.com/vijaypawar30)
- 📧 Email: vijaypawar6008@gmail.com

---

⭐ If you find this project helpful, please give it a star!
