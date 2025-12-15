# E-Commerce Management System / Система управления интернет-магазином

## 🇷🇺 Описание проекта (Russian)

### Краткое описание
Полнофункциональное веб-приложение для управления интернет-магазином, разработанное на Spring Boot с использованием современных технологий Java. Система предоставляет полный цикл управления товарами, заказами, пользователями и логистикой.

### Основные возможности
- **Управление товарами**: полный CRUD функционал для создания, редактирования, удаления и просмотра товаров
- **Система заказов**: создание заказов, отслеживание статусов, управление доставкой
- **Аутентификация и авторизация**: система входа с ролевой моделью доступа
- **Управление каталогом**: категории товаров, производители, поставщики, единицы измерения
- **Пункты выдачи**: управление точками самовывоза заказов
- **Поиск и сортировка**: удобный поиск товаров с различными вариантами сортировки
- **Управление скидками**: система скидок с максимальными и текущими значениями
- **Фотографии товаров**: загрузка и хранение изображений в базе данных

### Технический стек
**Backend:**
- Java 17
- Spring Boot 4.0.0
- Spring Web (REST API)
- Spring Data JPA (работа с БД)
- Spring Boot DevTools (для разработки)

**Frontend:**
- Thymeleaf (шаблонизатор)
- HTML/CSS

**База данных:**
- PostgreSQL

**Дополнительные библиотеки:**
- MapStruct 1.6.3 (маппинг DTO)
- Maven (сборка проекта)

### Архитектура
Проект построен по принципам многослойной архитектуры:
- **Controllers**: обработка HTTP запросов (REST API и MVC)
- **Services**: бизнес-логика приложения
- **Repositories**: слой доступа к данным (JPA)
- **Models**: JPA сущности для работы с БД
- **DTOs**: объекты передачи данных
- **Mappers**: конвертация между Entity и DTO (MapStruct)
- **Utils**: вспомогательные утилиты

### Основные компоненты

#### Контроллеры
- `MainPageController` - главная страница с каталогом товаров
- `ProductsController` - REST API для управления товарами
- `OrdersController` - REST API для работы с заказами
- `LoginController` - аутентификация пользователей

#### Модели данных
- `Product` - товары с полной информацией (цена, скидки, остатки)
- `Order` - заказы со статусами и датами
- `OrderProduct` - связь заказов и товаров (корзина)
- `User` - пользователи с ролями
- `Category`, `Supplier`, `Manufacturer` - справочники
- `PickUpPoint` - пункты выдачи

### Функциональные особенности
- Сессионная аутентификация пользователей
- Ролевая модель доступа (Role-based Access Control)
- Автоматический расчет финальной цены с учетом скидок
- Генерация уникальных кодов получения заказа
- Отслеживание количества товара на складе
- Фильтрация и поиск по каталогу товаров
- Управление статусами заказов (NEW, COMPLETED, CANCELLED и др.)

### Навыки и технологии
В процессе разработки проекта были применены:
- Проектирование RESTful API
- Работа с ORM (Hibernate через Spring Data JPA)
- Архитектурные паттерны (MVC, Repository, DTO)
- Dependency Injection через Spring
- Работа с реляционными БД и написание SQL запросов
- Маппинг объектов с MapStruct
- Работа с сессиями и аутентификацией
- Обработка multipart/form-data для загрузки изображений
- Maven для сборки и управления зависимостями

---

## 🇬🇧 Project Description (English)

### Overview
A full-featured web application for e-commerce management, developed with Spring Boot using modern Java technologies. The system provides a complete lifecycle management for products, orders, users, and logistics.

### Key Features
- **Product Management**: full CRUD functionality for creating, editing, deleting, and viewing products
- **Order System**: order creation, status tracking, delivery management
- **Authentication & Authorization**: login system with role-based access control
- **Catalog Management**: product categories, manufacturers, suppliers, unit types
- **Pick-up Points**: management of order collection points
- **Search & Sorting**: convenient product search with various sorting options
- **Discount Management**: discount system with maximum and current values
- **Product Images**: image upload and storage in database

### Technology Stack
**Backend:**
- Java 17
- Spring Boot 4.0.0
- Spring Web (REST API)
- Spring Data JPA (database operations)
- Spring Boot DevTools (development)

**Frontend:**
- Thymeleaf (templating engine)
- HTML/CSS

**Database:**
- PostgreSQL

**Additional Libraries:**
- MapStruct 1.6.3 (DTO mapping)
- Maven (build tool)

### Architecture
The project follows a multi-layered architecture pattern:
- **Controllers**: HTTP request handling (REST API and MVC)
- **Services**: business logic layer
- **Repositories**: data access layer (JPA)
- **Models**: JPA entities for database operations
- **DTOs**: Data Transfer Objects
- **Mappers**: Entity-DTO conversion (MapStruct)
- **Utils**: helper utilities

### Main Components

#### Controllers
- `MainPageController` - main page with product catalog
- `ProductsController` - REST API for product management
- `OrdersController` - REST API for order operations
- `LoginController` - user authentication

#### Data Models
- `Product` - products with full information (price, discounts, stock)
- `Order` - orders with statuses and dates
- `OrderProduct` - order-product relationship (shopping cart)
- `User` - users with roles
- `Category`, `Supplier`, `Manufacturer` - reference data
- `PickUpPoint` - pick-up locations

### Functional Features
- Session-based user authentication
- Role-based Access Control (RBAC)
- Automatic final price calculation with discounts
- Unique order pickup code generation
- Stock quantity tracking
- Product catalog filtering and search
- Order status management (NEW, COMPLETED, CANCELLED, etc.)

### Skills and Technologies
The following skills and technologies were applied during development:
- RESTful API design
- ORM usage (Hibernate via Spring Data JPA)
- Architectural patterns (MVC, Repository, DTO)
- Dependency Injection with Spring
- Relational database design and SQL queries
- Object mapping with MapStruct
- Session management and authentication
- Multipart/form-data handling for image uploads
- Maven for build and dependency management

---

## 🚀 Setup and Installation

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- PostgreSQL 12+

### Database Setup
1. Create a PostgreSQL database:
```sql
CREATE DATABASE trade;
```

2. Update database credentials in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/trade
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Running the Application

#### Using Maven Wrapper
```bash
# Linux/macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

#### Using Maven
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### Building the Project
```bash
# Create executable JAR
./mvnw clean package

# Run the JAR
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

---

## 📋 API Endpoints

### Products
- `PUT /products/update/{id}` - Update product
- `POST /products/create` - Create new product
- `DELETE /products/delete/{id}` - Delete product

### Orders
- `POST /orders/create` - Create new order
- `GET /orders/my` - Get user's orders

### Main Pages
- `GET /` - Main page with product catalog
- `GET /login` - Login page

---

## 👨‍💻 Developer Notes

This project demonstrates:
- **Clean Architecture**: separation of concerns with clear layers
- **Best Practices**: following Spring Boot conventions and Java standards
- **Modern Stack**: using current versions of frameworks and libraries
- **Production-Ready**: includes proper error handling and data validation
- **Scalable Design**: ready for expansion and new features

---

## 📝 Resume Summary

**E-Commerce Management System** - A comprehensive Spring Boot application demonstrating full-stack Java development skills with REST API design, database management, and modern enterprise patterns. Features include product catalog management, order processing, user authentication, and inventory tracking with a clean MVC architecture.

**Key Achievements:**
- Designed and implemented RESTful API with CRUD operations
- Integrated Spring Data JPA with PostgreSQL for data persistence
- Implemented role-based access control and session management
- Developed DTO pattern with MapStruct for clean data transfer
- Created responsive web interface using Thymeleaf templates

**Technologies:** Java 17, Spring Boot, Spring Data JPA, PostgreSQL, Thymeleaf, MapStruct, Maven
