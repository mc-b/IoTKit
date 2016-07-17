FROM ubuntu:14.04
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

RUN apt-get update && apt-get install -y wget curl npm software-properties-common expect

# Apache Cordova 
RUN sudo add-apt-repository ppa:cordova-ubuntu/ppa && sudo apt-get update 
RUN sudo apt-get -y install cordova-cli

# Android SDK
RUN dpkg --add-architecture i386
RUN apt-get update -qq
RUN apt-get install -y --no-install-recommends openjdk-7-jdk libncurses5:i386 libstdc++6:i386 zlib1g:i386 maven ant git mercurial

# Jenkins is run with user `jenkins`, uid = 1000
ENV JENKINS_HOME /var/jenkins
RUN useradd -d "$JENKINS_HOME" -u 1000 -m -s /bin/bash jenkins
RUN chown jenkins:jenkins /opt
USER jenkins

# Android with Android 5.x SDK
RUN cd /opt && curl -O http://dl.google.com/android/android-sdk_r24.4.1-linux.tgz 
RUN cd /opt && tar xzf android-sdk_r24.4.1-linux.tgz 
RUN cd /opt && rm -f android-sdk_r24.4.1-linux.tgz 

ENV ANDROID_HOME /opt/android-sdk-linux
ENV PATH ${PATH}:${ANDROID_HOME}/tools:${ANDROID_HOME}/platform-tools

COPY tools /opt/sdk-tools
USER root
RUN chmod 755 /opt/sdk-tools/*
USER jenkins
ENV PATH ${PATH}:/opt/sdk-tools

RUN ["/opt/sdk-tools/android-accept-licenses.sh", "android update sdk --filter tools --no-ui --force -a"]
RUN ["/opt/sdk-tools/android-accept-licenses.sh", "android update sdk --filter platform-tools --no-ui --force -a"]
RUN ["/opt/sdk-tools/android-accept-licenses.sh", "android update sdk --filter \"build-tools-23.0.1\" --no-ui --force -a"]
RUN ["/opt/sdk-tools/android-accept-licenses.sh", "android update sdk --filter \"extra-android-support\" --no-ui --force -a"]
RUN ["/opt/sdk-tools/android-accept-licenses.sh", "android update sdk --filter \"android-21\" --no-ui --force -a"]
RUN ["/opt/sdk-tools/android-accept-licenses.sh", "android update sdk --filter \"extra-android-m2repository\" --no-ui --force -a"]
RUN ["/opt/sdk-tools/android-accept-licenses.sh", "android update sdk --filter \"extra-google-m2repository\" --no-ui --force -a"]
RUN ["/opt/sdk-tools/android-accept-licenses.sh", "android update sdk --filter \"extra-google-google_play_services\" --no-ui --force -a"]

# Android 4.4 SDK
RUN ["/opt/sdk-tools/android-accept-licenses.sh", "android update sdk --filter \"android-19\" --no-ui --force -a"]

RUN mkdir /opt/jenkins
RUN wget http://mirrors.jenkins-ci.org/war/latest/jenkins.war -O /opt/jenkins/jenkins.war

# Jenkins Jobs
USER jenkins
RUN mkdir -p $JENKINS_HOME/jobs/simpleAPP
RUN mkdir -p $JENKINS_HOME/workspace/simpleAPP
COPY simpleAPP.xml $JENKINS_HOME/jobs/simpleAPP/config.xml

RUN mkdir -p $JENKINS_HOME/jobs/HERMES5
RUN mkdir -p $JENKINS_HOME/workspace/HERMES5
COPY HERMES5.xml $JENKINS_HOME/jobs/HERMES5/config.xml

RUN mkdir -p $JENKINS_HOME/jobs/IoTKitAPP
RUN mkdir -p $JENKINS_HOME/workspace/IoTKitAPP
COPY IoTKitAPP.xml $JENKINS_HOME/jobs/IoTKitAPP/config.xml

RUN mkdir -p $JENKINS_HOME/jobs/IoTKitRobotAPP
RUN mkdir -p $JENKINS_HOME/workspace/IoTKitRobotAPP
COPY IoTKitRobotAPP.xml $JENKINS_HOME/jobs/IoTKitRobotAPP/config.xml

# Arbeitsverzeichnis
USER root
VOLUME [ "/var/www/html/download" ]
RUN mkdir -p /var/cordova
RUN chown -R jenkins:jenkins /var/cordova /var/www/html/download
ENV DEPLOY_DIR=/var/www/html/download/

USER jenkins
WORKDIR /var/cordova
COPY bash_history /var/jenkins/.bash_history

EXPOSE 8080

ENTRYPOINT cd /opt/jenkins && java -jar ./jenkins.war --prefix=/cordova

