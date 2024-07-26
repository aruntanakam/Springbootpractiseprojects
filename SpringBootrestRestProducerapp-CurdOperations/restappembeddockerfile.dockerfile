FROM openjdk:17.0.2

WORKDIR /app

COPY target/restapp.war /app/restapp.war

ENV DB_URL=jdbc:mysql://localhost:3306/restapp

ENV DB_USERNAME=restuser


EXPOSE 4000

ENTRYPOINT [ "java","-jar","restapp.war" ]