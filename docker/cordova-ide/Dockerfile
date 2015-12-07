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

# Initialization Startup Script
ADD start.sh /start.sh
RUN chmod 755 /start.sh

# Projekt in workspace
USER jenkins
WORKDIR /var/cordova
RUN git clone https://github.com/mc-b/IoTKit.git

EXPOSE 8000 8080

ENTRYPOINT ["/start.sh"]
