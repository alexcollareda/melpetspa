# Usa uma imagem base Java Development Kit (JDK) 21 leve
FROM eclipse-temurin:21-jre-jammy

# Instala 'curl' para ser usado na verificação de saúde (HEALTHCHECK)
# 'apt-get update' atualiza a lista de pacotes
# 'apt-get install -y curl' instala o curl sem pedir confirmação
# 'rm -rf /var/lib/apt/lists/*' limpa o cache do apt para reduzir o tamanho final da imagem
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR da sua aplicação para o contêiner
# Assumindo que seu build Gradle gera o JAR em build/libs/melpetspa-0.0.1-SNAPSHOT.jar
# Verifique o nome exato do seu JAR após o comando './gradlew clean build'
ARG JAR_FILE=build/libs/melpetspa-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Expõe a porta que sua aplicação Spring Boot usa (definida no application.properties, ex: 8081)
EXPOSE 8081

# Comando para rodar a aplicação quando o contêiner iniciar
ENTRYPOINT ["java", "-Xmx256m", "-Xms64m", "-jar", "app.jar"]

# Define um health check para verificar a saúde da aplicação Spring Boot
# --interval: Frequência da verificação (a cada 30 segundos)
# --timeout: Tempo máximo de espera pela resposta (10 segundos)
# --retries: Número de falhas consecutivas antes de marcar o contêiner como 'unhealthy' (3 tentativas)
# --start-period: Período inicial para a aplicação subir sem ser marcada como 'unhealthy' (60 segundos)
# CMD: Comando a ser executado para o health check
# 'curl --fail http://localhost:8081/actuator/health' tenta acessar o endpoint de saúde
# '|| exit 1' faz com que o health check falhe se o 'curl' não obtiver sucesso (código de retorno não-zero)
HEALTHCHECK --interval=30s --timeout=10s --retries=3 --start-period=60s \
  CMD curl --fail http://localhost:8081/actuator/health || exit 1