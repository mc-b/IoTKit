FROM ubuntu:14.04
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

RUN apt-get update
RUN apt-get install -y mosquitto mosquitto-clients supervisor

RUN adduser --system --disabled-password --disabled-login mosquitto

VOLUME ["/mqtt/config", "/mqtt/data", "/mqtt/log"]
RUN chmod 777 /mqtt

EXPOSE 1883 

COPY mosquitto.conf /mqtt/config/mosquitto.conf
COPY supervisord.conf /etc/supervisor/conf.d/supervisord.conf

ENTRYPOINT ["/usr/bin/supervisord"]

