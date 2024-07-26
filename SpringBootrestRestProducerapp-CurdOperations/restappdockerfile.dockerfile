FROM tomcat:10.1.26-jre17-temurin-jammy

RUN mv /usr/local/tomcat/webapps /usr/local/tomcat/webapps2

RUN mv /usr/local/tomcat/webapps.dist /usr/local/tomcat/webapps

COPY target/restapp.war /usr/local/tomcat/webapps/

ENV DB_URL=jdbc:mysql://aktapp.ddns.net:3306/restapp

ENV DB_USERNAME=restuser

ENV DB_PASSWORD=restuser@123

EXPOSE 8080

CMD ["catalina.sh","run"]