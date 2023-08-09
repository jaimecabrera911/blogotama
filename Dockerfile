# Utiliza una imagen base con Java 17
FROM eclipse-temurin:17-jdk-focal

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de la aplicación al contenedor
COPY ./build/libs/BlogoramaApi-0.0.1-SNAPSHOT.jar /app/app.jar

# Expone el puerto 8080
EXPOSE 8080

# Variables de entorno para la base de datos
ENV DATABASE_HOST=dpg-cja2eqtm2m9c73b5a2k0-a.oregon-postgres.render.com
ENV DATABASE_USERNAME=root
ENV DATABASE_PORT=5432
ENV DATABASE_PASSWORD=WqFVnZPGiCKvuWzqS0lBM3jIJruJY0tx
ENV DATABASE_DB_NAME=my_db_jiyn
ENV DATABASE_SCHEMA_NAME=blogorama

# Comando para ejecutar la aplicación cuando el contenedor inicie
CMD ["java", "-jar", "app.jar"]
