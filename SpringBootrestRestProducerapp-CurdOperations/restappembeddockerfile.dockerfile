FROM openjdk:17.0.2

WORKDIR /app

COPY target/restapp.war /app/restapp.war

ENV DB_HOST=localhost

ENV DB_USERNAME=retuser

ENV DB_PASSWORD=restuser@123

ENV lOGICAL_DATABASE=restappdb


EXPOSE 4000

ENTRYPOINT [ "java","-jar","restapp.war" ]