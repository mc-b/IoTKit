FROM ruby:2.1.4
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

ENV DEBIAN_FRONTEND noninteractive
RUN apt-get update && apt-get install -y build-essential mysql-server mysql-client git curl 

# ThingSpeak
WORKDIR /opt/

# thingspeak SETUP
RUN git clone https://github.com/iobridge/thingspeak.git
WORKDIR /opt/thingspeak
RUN bundle install

# add user thingspeak to image
RUN groupadd -r thingspeak && useradd -r -g thingspeak thingspeak
RUN chown -R thingspeak /opt/thingspeak
RUN chgrp -R thingspeak /opt/thingspeak

RUN cp config/database.yml.example config/database.yml

# Initialization Startup Script
ADD start.sh /start.sh
RUN chmod 755 /start.sh
	
EXPOSE 3000

ENTRYPOINT [ "/start.sh" ]