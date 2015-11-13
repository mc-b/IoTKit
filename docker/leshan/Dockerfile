FROM ubuntu:latest
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

RUN apt-get update
RUN apt-get install -y openjdk-7-jre-headless wget

RUN mkdir /opt/leshan
RUN wget https://hudson.eclipse.org/leshan/job/leshan/lastSuccessfulBuild/artifact/leshan-standalone.jar -O /opt/leshan/leshan.jar

EXPOSE 8080 5683/udp

ENTRYPOINT cd /opt/leshan && java -jar ./leshan.jar

