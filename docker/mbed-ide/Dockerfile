FROM marcel1691/jenkins
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

# codebox ide 
USER root
RUN apt-get update && apt-get install -y make g++ python git curl supervisor mosquitto-clients mysql-client 
RUN curl -sL https://deb.nodesource.com/setup | sudo bash - && apt-get install -y nodejs
RUN	npm -g install node-gyp codebox
RUN cd /usr/lib/node_modules/codebox/node_modules/shux/node_modules/pty.js && make clean && make

ENV CODEBOX_USERNAME guest
ENV CODEBOX_PASSWORD guest-

# Initialization Startup Script
ADD start.sh /start.sh
RUN chmod 755 /start.sh

# Projekt in workspace
USER jenkins
WORKDIR /var/workspace
RUN git clone https://github.com/ARMmbed/example-mbedos-blinky.git
RUN hg clone https://developer.mbed.org/teams/smdiotkitch/code/AnalogIn/ && \
	hg clone https://developer.mbed.org/teams/smdiotkitch/code/DigitalOut/
RUN hg clone https://developer.mbed.org/teams/smdiotkitch/code/LichtSensor/
RUN hg clone https://developer.mbed.org/teams/smdiotkitch/code/PIRSensor/
RUN hg clone https://developer.mbed.org/teams/smdiotkit1ch/code/Polling/
RUN hg clone https://developer.mbed.org/teams/smdiotkitch/code/PwmOut/
RUN hg clone https://developer.mbed.org/teams/smdiotkitch/code/PwmOutPeriod/
RUN hg clone https://developer.mbed.org/teams/smdiotkit1ch/code/RGBLEDStrip/
RUN hg clone https://developer.mbed.org/teams/smdiotkit1ch/code/RGBLEDStripSPI/
RUN hg clone https://developer.mbed.org/teams/smdiotkit1ch/code/Schrittmotor/
RUN hg clone https://developer.mbed.org/teams/smdiotkit1ch/code/SDCardFS/
RUN hg clone https://developer.mbed.org/teams/smdiotkit1ch/code/SDCardIO/
RUN hg clone https://developer.mbed.org/teams/smdiotkitch/code/Ethernet/
COPY makefile.codebox /var/workspace/Makefile

COPY bash_history ${JENKINS_HOME}/.bash_history

EXPOSE 8000 8080

ENTRYPOINT ["/start.sh"]
