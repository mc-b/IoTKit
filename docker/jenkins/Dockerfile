FROM mbed/yotta
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

RUN apt-get update
RUN apt-get install -y openjdk-7-jre-headless wget

# Jenkins is run with user `jenkins`, uid = 1000
# If you bind mount a volume from the host or a data container, 
# ensure you use the same uid
ENV JENKINS_HOME /var/jenkins
RUN useradd -d "$JENKINS_HOME" -u 1000 -m -s /bin/bash jenkins

RUN mkdir /opt/jenkins
RUN wget http://mirrors.jenkins-ci.org/war/latest/jenkins.war -O /opt/jenkins/jenkins.war

USER jenkins

RUN mkdir -p $JENKINS_HOME/jobs/example-mbedos-blinky
RUN mkdir -p $JENKINS_HOME/workspace/example-mbedos-blinky
COPY example-mbedos-blinky.xml $JENKINS_HOME/jobs/example-mbedos-blinky/config.xml

EXPOSE 8080

ENTRYPOINT cd /opt/jenkins && java -jar ./jenkins.war

