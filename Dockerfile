FROM hub.c.163.com/library/tomcat:8-jre8-alpine

WORKDIR /usr/local/tomcat

ADD mvc.war /usr/local/tomcat/webapps/ROOT

