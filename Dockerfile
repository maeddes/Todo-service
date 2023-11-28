FROM eclipse-temurin:17
RUN mkdir -p /opt/todo-app-backend
WORKDIR /opt/todo-app-backend
COPY target/todo-app-0.0.1-SNAPSHOT.jar /opt/todo-app-backend
CMD ["java", "-jar", "todo-app-0.0.1-SNAPSHOT.jar"]