# GameFlix Backend - Dockerized Spring Boot App

## How to Build and Run

### 1. Build the `.jar` File
./gradlew bootJar

shell
Copy
Edit

### 2. Build Docker Image
docker build -t gameflix-backend .

shell
Copy
Edit

### 3. Run Docker Container
docker run -p 9090:8080 gameflix-backend

makefile
Copy
Edit

### 4. Test in Browser
Visit:
http://localhost:9090/api/ping

pgsql
Copy
Edit
✅ Output: `Server is alive!`
