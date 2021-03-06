FROM ubuntu:14.04
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

RUN apt-get update
RUN apt-get install -y openjdk-7-jre-headless wget mercurial git cppcheck unzip curl

# Jenkins is run with user `jenkins`, uid = 1000
ENV JENKINS_HOME /var/jenkins
RUN useradd -d "$JENKINS_HOME" -u 1000 -m -s /bin/bash jenkins
RUN chown jenkins:jenkins /opt

# Jenkins WAR
USER jenkins
RUN mkdir /opt/jenkins
RUN wget http://mirrors.jenkins-ci.org/war/latest/jenkins.war -O /opt/jenkins/jenkins.war

# mbed cli
USER root
RUN apt-get -y install python python-pip lib32z1 lib32ncurses5 lib32bz2-1.0 lib32ncurses5 build-essential \
			   software-properties-common python3-software-properties python-software-properties
RUN add-apt-repository ppa:team-gcc-arm-embedded/ppa
RUN apt-get update
RUN apt-get -y install gcc-arm-embedded
RUN pip install mbed-cli
USER jenkins
RUN mbed config --global TARGET K64F
RUN mbed config --global TOOLCHAIN GCC_ARM

# Jenkins Jobs (smd.iotkit.ch)
RUN mkdir -p $JENKINS_HOME/jobs/example-mbedos-blinky $JENKINS_HOME/workspace/example-mbedos-blinky
COPY example-mbedos-blinky.xml $JENKINS_HOME/jobs/example-mbedos-blinky/config.xml

RUN mkdir -p $JENKINS_HOME/jobs/DigitalOut $JENKINS_HOME/workspace/DigitalOut
COPY DigitalOut.xml $JENKINS_HOME/jobs/DigitalOut/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/Ethernet $JENKINS_HOME/workspace/Ethernet
COPY Ethernet.xml $JENKINS_HOME/jobs/Ethernet/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/LichtSensor $JENKINS_HOME/workspace/LichtSensor
COPY LichtSensor.xml $JENKINS_HOME/jobs/LichtSensor/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/PwmOutPeriod $JENKINS_HOME/workspace/PwmOutPeriod
COPY PwmOutPeriod.xml $JENKINS_HOME/jobs/PwmOutPeriod/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/PwmOut $JENKINS_HOME/workspace/PwmOut
COPY PwmOut.xml $JENKINS_HOME/jobs/PwmOut/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/AnalogIn $JENKINS_HOME/workspace/AnalogIn
COPY AnalogIn.xml $JENKINS_HOME/jobs/AnalogIn/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/PIRSensor $JENKINS_HOME/workspace/PIRSensor
COPY PIRSensor.xml $JENKINS_HOME/jobs/PIRSensor/config.xml

# Jenkins Jobs (smd.iotkit1.ch)
RUN mkdir -p $JENKINS_HOME/jobs/SDCardFS $JENKINS_HOME/workspace/SDCardFS
COPY SDCardFS.xml $JENKINS_HOME/jobs/SDCardFS/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/Polling $JENKINS_HOME/workspace/Polling
COPY Polling.xml $JENKINS_HOME/jobs/Polling/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/RGBLEDStripSPI $JENKINS_HOME/workspace/RGBLEDStripSPI
COPY RGBLEDStripSPI.xml $JENKINS_HOME/jobs/RGBLEDStripSPI/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/SDCardIO $JENKINS_HOME/workspace/SDCardIO
COPY SDCardIO.xml $JENKINS_HOME/jobs/SDCardIO/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/Schrittmotor $JENKINS_HOME/workspace/Schrittmotor
COPY Schrittmotor.xml $JENKINS_HOME/jobs/Schrittmotor/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/RGBLEDStrip $JENKINS_HOME/workspace/RGBLEDStrip
COPY RGBLEDStrip.xml $JENKINS_HOME/jobs/RGBLEDStrip/config.xml 

# Jenkins Jobs (smd.iotkit2.ch)
RUN mkdir -p $JENKINS_HOME/jobs/JSONParser $JENKINS_HOME/workspace/JSONParser
COPY JSONParser.xml $JENKINS_HOME/jobs/JSONParser/config.xml

# Jenkins Konfiguration (nur 1 Build Prozessor gleichzeitig)
COPY config.xml /var/jenkins

# Arbeitsverzeichnis
USER root
RUN mkdir -p /var/workspace && chown -R jenkins:jenkins /var/workspace

# Jenkins Plug-Ins
USER root
ENV JENKINS_UC https://updates.jenkins-ci.org
COPY plugins.sh /usr/local/bin/plugins.sh
RUN chmod +x /usr/local/bin/plugins.sh
COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt
RUN chown jenkins:jenkins /usr/share/jenkins/ref
RUN mkdir -p $JENKINS_HOME/plugins && cp /usr/share/jenkins/ref/plugins/* $JENKINS_HOME/plugins/ && chown jenkins:jenkins $JENKINS_HOME/plugins

USER jenkins
WORKDIR /var/workspace

EXPOSE 8080

ENTRYPOINT cd /opt/jenkins && java -jar ./jenkins.war --prefix=/mbed


