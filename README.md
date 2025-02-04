# Flight Management System

## Overview
A high-performance Flight Management System built with Spring Boot that efficiently handles flight routes and path computations. The system implements an optimized route-finding algorithm with caching to deliver fast response times for route queries.

## Technologies Used
- Java
- Spring Boot
- Spring MVC
- Hibernate
- MySQL
- Maven/Gradle

## Key Features
- Efficient route-finding algorithm with O(n log n) complexity
- Caching mechanism for improved performance
- Handles 1000+ routes with <50ms response time
- RESTful API endpoints for flight management
- Database persistence with Hibernate

## Installation & Setup
1. Clone the repository
```bash
git clone [repository-url]
```

2. Configure MySQL database settings in `application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/flight_management
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Build the project
```bash
mvn clean install
```

4. Run the application
```bash
mvn spring-boot:run
```

## API Endpoints
- `GET /api/routes` - Get all available routes
- `GET /api/routes/{id}` - Get route by ID
- `POST /api/routes` - Create new route
- `PUT /api/routes/{id}` - Update existing route
- `DELETE /api/routes/{id}` - Delete route

## Performance
- Route computation optimization: O(n²) → O(n log n)
- Response time: <50ms for 1000+ routes
- Caching implementation for frequently accessed routes

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
