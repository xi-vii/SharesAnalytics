FROM tomcat:9.0.90-jdk11-temurin-jammy
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./target/SharesAnalytics.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]