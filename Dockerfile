# Maven için temel imaj
FROM maven:3.9.4-eclipse-temurin-21 AS build

# Çalışma dizinini ayarla
WORKDIR /app

# Maven projelerini kopyala
COPY pom.xml .
COPY src ./src

# Maven bağımlılıklarını indir ve projeyi derle
RUN mvn clean package -DskipTests

# Çalıştırma için temel imaj
FROM eclipse-temurin:21-jdk-alpine

# Çalışma dizinini ayarla
WORKDIR /app

# Derlenen jar dosyasını kopyala
COPY --from=build /app/target/*.jar app.jar

# Portu aç
EXPOSE 8080

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "app.jar"]
