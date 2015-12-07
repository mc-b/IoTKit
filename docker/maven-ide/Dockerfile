FROM marcel1691/maven
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

# codebox ide 
USER root
RUN apt-get update && apt-get install -y make g++ python git curl supervisor
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
RUN git clone https://github.com/eclipse/leshan.git

EXPOSE 8000 8080

ENTRYPOINT ["/start.sh"]
