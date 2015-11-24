FROM mbed/yotta
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

RUN apt-get update
RUN apt-get install -y openjdk-7-jre-headless wget mercurial git

# Jenkins is run with user `jenkins`, uid = 1000
ENV JENKINS_HOME /var/jenkins
RUN useradd -d "$JENKINS_HOME" -u 1000 -m -s /bin/bash jenkins
RUN chown jenkins:jenkins /opt

# Jenkins WAR
USER jenkins
RUN mkdir /opt/jenkins
RUN wget http://mirrors.jenkins-ci.org/war/latest/jenkins.war -O /opt/jenkins/jenkins.war

# GCC4mbed
WORKDIR /opt
RUN git clone https://github.com/adamgreen/gcc4mbed.git
ENV GCC4MBED_DIR=/opt/gcc4mbed
ENV GCC4MBED_TOOLPATH=/usr/bin
ENV DEVICES=MCU_K64F 
ADD MCU_K64F-device.mk ${GCC4MBED_DIR}/build
#RUN cd ${GCC4MBED_DIR} && make

# Jenkins Jobs
RUN mkdir -p $JENKINS_HOME/jobs/example-mbedos-blinky
RUN mkdir -p $JENKINS_HOME/workspace/example-mbedos-blinky
COPY example-mbedos-blinky.xml $JENKINS_HOME/jobs/example-mbedos-blinky/config.xml

RUN mkdir -p $JENKINS_HOME/jobs/DigitalOut
RUN mkdir -p $JENKINS_HOME/workspace/DigitalOut
COPY DigitalOut.xml $JENKINS_HOME/jobs/DigitalOut/config.xml

EXPOSE 8080

ENTRYPOINT cd /opt/jenkins && java -jar ./jenkins.war

