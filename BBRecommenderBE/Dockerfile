#docker inmage for a spring boot backend openjdk:17-jdk-alpine
FROM openjdk:17-jdk-alpine
RUN addgroup --system bebold
RUN adduser --system -G bebold rudy
USER rudy
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} app.jar

# Copy the current directory contents into the container at /app
COPY ./target/bbrecommenderbe-0.0.1.jar app.jar

EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app.jar"]

# RUN addgroup --system bebold
# RUN adduser --system -G bebold rudy
# USER rudy
# ARG JAR_FILE=target/bbrecommenderbe-0.0.1-SNAPSHOT.jar 
# ADD ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]
# EXPOSE 8085

#run the docker image
    #docker build -t bbrbe .
    #docker run --name=backend -p 8080:8080 bbrbe

#run docker image in bash (dev mode)
    #docker run --name=backend -it bbrbe /bin/sh
    #java -jar BBRecommenderBE-0.0.1-SNAPSHOT.jar




