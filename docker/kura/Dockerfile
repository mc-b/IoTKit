FROM ubuntu:latest
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

RUN apt-get update
RUN apt-get install -y openjdk-7-jdk wget maven git curl dos2unix zip

# HTTP, MQTT, CoAP
EXPOSE 8080 1883 5683/udp

RUN cd /opt && git clone -b develop https://github.com/eclipse/kura.git
RUN cd /opt/kura/target-platform && mvn clean install
RUN cd /opt/kura/kura/ && mvn -Dmaven.test.skip=true -f manifest_pom.xml clean install
RUN cd /opt/kura/kura/ && mvn -Dmaven.test.skip=true -f pom_pom.xml -Pweb clean install

RUN cd /opt/kura/kura/distrib/target && mv kura_1.4.0-SNAPSHOT_intel-edison*.zip /opt
RUN cd /opt && unzip kura_1.4.0-SNAPSHOT_intel-edison.zip

WORKDIR /opt/kura_1.4.0-SNAPSHOT_intel-edison

#ENTRYPOINT cd /opt/leshan && java -jar ./leshan.jar

