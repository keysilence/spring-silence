FROM hub.c.163.com/library/tomcat:8-jre8-alpine

WORKDIR /usr/local/tomcat

ADD mvc.war /usr/local/tomcat/webapps/ROOT
RUN cd /usr/local/tomcat/webapps/ROOT && unzip mvc.war && \
    rm -f mvc.war && ls -lha && \
    echo `date +%Y-%m-%d:%H:%M:%S` > /etc/docker.build
