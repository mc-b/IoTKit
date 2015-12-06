FROM marcel1691/cordova
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

# codebox ide 
USER root
WORKDIR /
RUN apt-get update && apt-get install -y make g++ python git curl supervisor
RUN curl -sL https://deb.nodesource.com/setup | sudo bash - && apt-get install -y nodejs
# Installation ohne node-gyp und pty.js - weil schon in cordova enthalten
RUN	npm -g install codebox

ENV CODEBOX_USERNAME guest
ENV CODEBOX_PASSWORD guest-

COPY supervisord.conf /etc/supervisor/conf.d/supervisord.conf
EXPOSE 8000 8080

ENTRYPOINT ["/usr/bin/supervisord"]
