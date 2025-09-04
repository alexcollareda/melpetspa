# Usa uma imagem base Java Development Kit (JDK) 21 leve
FROM eclipse-temurin:21-jre-jammy

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR da sua aplicação para o contêiner
# Assumindo que seu build Gradle gera o JAR em build/libs/autosafe-consumer-0.0.1-SNAPSHOT.jar
# Verifique o nome exato do seu JAR após o comando './gradlew clean build'
ARG JAR_FILE=build/libs/melpetspa-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Expõe a porta que sua aplicação Spring Boot usa (definida no application.properties, ex: 8084)
EXPOSE 8081

# Comando para rodar a aplicação quando o contêiner iniciar
ENTRYPOINT ["java", "-jar", "app.jar"]