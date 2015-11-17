FROM ubuntu:latest
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

RUN apt-get update
RUN apt-get install -y mosquitto mosquitto-clients

RUN adduser --system --disabled-password --disabled-login mosquitto

VOLUME ["/mqtt/config", "/mqtt/data", "/mqtt/log"]
RUN chmod 777 /mqtt

EXPOSE 1883 

COPY mosquitto.conf /mqtt/config/mosquitto.conf

ENTRYPOINT [ "/usr/sbin/mosquitto", "-c", "/mqtt/config/mosquitto.conf" ]

