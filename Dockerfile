FROM eclipse-temurin:24-jdk

WORKDIR /app
COPY . .

# Give mvnw executable permission
RUN chmod +x mvnw

# Build the app
RUN ./mvnw clean package -DskipTests

CMD ["sh", "-c", "java -jar target/*.jar"]