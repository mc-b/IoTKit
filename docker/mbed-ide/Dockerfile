FROM marcel1691/jenkins
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

# codebox ide 
USER root
RUN apt-get update && apt-get install -y make g++ python git curl supervisor
RUN curl -sL https://deb.nodesource.com/setup | sudo bash - && apt-get install -y nodejs
RUN	npm -g install node-gyp codebox
RUN cd /usr/lib/node_modules/codebox/node_modules/shux/node_modules/pty.js && make clean && make

ENV CODEBOX_USERNAME guest
ENV CODEBOX_PASSWORD guest-

COPY supervisord.conf /etc/supervisor/conf.d/supervisord.conf
EXPOSE 8000 8080

# Projekt in workspace
WORKDIR /var/workspace
RUN git clone https://github.com/ARMmbed/example-mbedos-blinky.git
RUN hg clone https://developer.mbed.org/teams/smdiotkitch/code/AnalogIn/
RUN hg clone https://developer.mbed.org/teams/smdiotkitch/code/DigitalOut/

ENTRYPOINT ["/usr/bin/supervisord"]
