FROM ubuntu:14.04
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

RUN apt-get update
RUN apt-get install -y openjdk-7-jre-headless wget supervisor

RUN mkdir -p /opt/leshan /var/log/supervisor
RUN wget https://hudson.eclipse.org/leshan/job/leshan/lastSuccessfulBuild/artifact/leshan-standalone.jar -O /opt/leshan/leshan.jar

COPY leshan-client-example.jar /opt/leshan/leshan-client-example.jar
COPY supervisord.conf /etc/supervisor/conf.d/supervisord.conf

EXPOSE 8080 5683/udp

ENTRYPOINT ["/usr/bin/supervisord"]

