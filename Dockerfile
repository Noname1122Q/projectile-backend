# Use official OpenJDK image
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy everything
COPY . .

# Build the app
RUN ./mvnw clean package -DskipTests

# Run the jar
CMD ["sh", "-c", "java -jar target/*.jar"]