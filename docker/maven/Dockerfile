FROM ubuntu:14.04
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

RUN apt-get update && apt-get install -y wget openjdk-7-jdk maven git

# Jenkins is run with user `jenkins`, uid = 1000
ENV JENKINS_HOME /var/jenkins
RUN useradd -d "$JENKINS_HOME" -u 1000 -m -s /bin/bash jenkins
RUN chown jenkins:jenkins /opt
USER jenkins

RUN mkdir /opt/jenkins
RUN wget http://mirrors.jenkins-ci.org/war/latest/jenkins.war -O /opt/jenkins/jenkins.war

RUN mkdir -p $JENKINS_HOME/jobs/leshan
RUN mkdir -p $JENKINS_HOME/workspace/leshan
COPY leshan.xml $JENKINS_HOME/jobs/leshan/config.xml

RUN mkdir -p $JENKINS_HOME/jobs/openhab2
RUN mkdir -p $JENKINS_HOME/workspace/openhab2
COPY openhab2.xml $JENKINS_HOME/jobs/openhab2/config.xml

RUN mkdir -p $JENKINS_HOME/jobs/kura
RUN mkdir -p $JENKINS_HOME/workspace/kura
COPY kura.xml $JENKINS_HOME/jobs/kura/config.xml

RUN mkdir -p $JENKINS_HOME/jobs/iotkit
RUN mkdir -p $JENKINS_HOME/workspace/iotkit
COPY iotkit.xml $JENKINS_HOME/jobs/iotkit/config.xml

# Arbeitsverzeichnis
USER root
VOLUME [ "/var/www/html/download" ]
RUN mkdir -p /var/workspace && chown -R jenkins:jenkins /var/workspace /var/www/html/download
ENV DEPLOY_DIR /var/www/html/download/

USER jenkins
WORKDIR /var/workspace

EXPOSE 8080

ENTRYPOINT cd /opt/jenkins && java -jar ./jenkins.war --prefix=/maven

