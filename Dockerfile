FROM tomcat:8.0
MAINTAINER Dasha
RUN rm -rf /usr/local/tomcat/webapps/ROOT
COPY ./ROOT.war /usr/local/tomcat/webapps/
EXPOSE 8080