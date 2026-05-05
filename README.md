# Tweet-On-Y — Backend

A RESTful backend API built with **Spring Boot** that powers **Tweet-On-Y**, a Twitter-like social platform. Supports user registration, authentication, posting, liking, and commenting.

---

## 🚀 Tech Stack

- **Java** — Core language
- **Spring Boot** — Application framework
- **Spring Security + JWT** — Authentication & authorization
- **Spring Data JPA** — ORM and database interaction
- **MySQL .** — Relational database
- **Maven** — Dependency management

---

## ✨ Features

- 🔐 User Registration & Login (JWT-based authentication)
- 📝 Create and view text posts
- ❤️ Like / Unlike posts
- 💬 Comment on posts
- 👤 User profile management

---

## 📁 Project Structure

src/
├── main/
│   ├── java/com/tweeton-y/
│   │   ├── controller/       # REST API controllers
│   │   ├── service/          # Business logic
│   │   ├── repository/       # JPA repositories
│   │   ├── model/            # Entity classes
│   │   ├── dto/              # Data Transfer Objects
│   │   ├── security/         # JWT & Spring Security config
│   │   └── config/           # App configuration
│   └── resources/
│       └── application.properties
