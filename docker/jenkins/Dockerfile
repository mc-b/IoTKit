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

# Jenkins Jobs (smd.iotkit.ch)
RUN mkdir -p $JENKINS_HOME/jobs/example-mbedos-blinky
RUN mkdir -p $JENKINS_HOME/workspace/example-mbedos-blinky
COPY example-mbedos-blinky.xml $JENKINS_HOME/jobs/example-mbedos-blinky/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/DigitalOut
RUN mkdir -p $JENKINS_HOME/workspace/DigitalOut
COPY DigitalOut.xml $JENKINS_HOME/jobs/DigitalOut/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/Ethernet
RUN mkdir -p $JENKINS_HOME/workspace/Ethernet
COPY Ethernet.xml $JENKINS_HOME/jobs/Ethernet/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/HallSensor
RUN mkdir -p $JENKINS_HOME/workspace/HallSensor
COPY HallSensor.xml $JENKINS_HOME/jobs/HallSensor/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/LichtSensor
RUN mkdir -p $JENKINS_HOME/workspace/LichtSensor
COPY LichtSensor.xml $JENKINS_HOME/jobs/LichtSensor/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/DotLEDMatrix
RUN mkdir -p $JENKINS_HOME/workspace/DotLEDMatrix
COPY DotLEDMatrix.xml $JENKINS_HOME/jobs/DotLEDMatrix/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/LEDUI
RUN mkdir -p $JENKINS_HOME/workspace/LEDUI
COPY LEDUI.xml $JENKINS_HOME/jobs/LEDUI/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/PwmOutPeriod
RUN mkdir -p $JENKINS_HOME/workspace/PwmOutPeriod
COPY PwmOutPeriod.xml $JENKINS_HOME/jobs/PwmOutPeriod/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/PwmOut
RUN mkdir -p $JENKINS_HOME/workspace/PwmOut
COPY PwmOut.xml $JENKINS_HOME/jobs/PwmOut/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/AnalogIn
RUN mkdir -p $JENKINS_HOME/workspace/AnalogIn
COPY AnalogIn.xml $JENKINS_HOME/jobs/AnalogIn/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/PIRSensor
RUN mkdir -p $JENKINS_HOME/workspace/PIRSensor
COPY PIRSensor.xml $JENKINS_HOME/jobs/PIRSensor/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/RTC
RUN mkdir -p $JENKINS_HOME/workspace/RTC
COPY RTC.xml $JENKINS_HOME/jobs/RTC/config.xml

# Jenkins Jobs (smd.iotkit1.ch)
RUN mkdir -p $JENKINS_HOME/jobs/SDCardFS
RUN mkdir -p $JENKINS_HOME/workspace/SDCardFS
COPY SDCardFS.xml $JENKINS_HOME/jobs/SDCardFS/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/Polling
RUN mkdir -p $JENKINS_HOME/workspace/Polling
COPY Polling.xml $JENKINS_HOME/jobs/Polling/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/ThreadSignal
RUN mkdir -p $JENKINS_HOME/workspace/ThreadSignal
COPY ThreadSignal.xml $JENKINS_HOME/jobs/ThreadSignal/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/RGBLEDStripSPI
RUN mkdir -p $JENKINS_HOME/workspace/RGBLEDStripSPI
COPY RGBLEDStripSPI.xml $JENKINS_HOME/jobs/RGBLEDStripSPI/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/SDCardIO
RUN mkdir -p $JENKINS_HOME/workspace/SDCardIO
COPY SDCardIO.xml $JENKINS_HOME/jobs/SDCardIO/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/Schrittmotor
RUN mkdir -p $JENKINS_HOME/workspace/Schrittmotor
COPY Schrittmotor.xml $JENKINS_HOME/jobs/Schrittmotor/config.xml
RUN mkdir -p $JENKINS_HOME/jobs/RGBLEDStrip
RUN mkdir -p $JENKINS_HOME/workspace/RGBLEDStrip
COPY RGBLEDStrip.xml $JENKINS_HOME/jobs/RGBLEDStrip/config.xml

# Jenkins Jobs (smd.iotkit2.ch)
RUN mkdir -p $JENKINS_HOME/jobs/JSONParser
RUN mkdir -p $JENKINS_HOME/workspace/JSONParser
COPY JSONParser.xml $JENKINS_HOME/jobs/JSONParser/config.xml

# Jenkins Konfiguration (nur 1 Build Prozessor gleichzeitig)
COPY config.xml /var/jenkins

# Arbeitsverzeichnis
USER root
VOLUME [ "/var/workspace" ]
RUN chown -R jenkins:jenkins /var/workspace

USER jenkins
WORKDIR /var/workspace

EXPOSE 8080

ENTRYPOINT cd /opt/jenkins && java -jar ./jenkins.war --prefix=/jenkins

