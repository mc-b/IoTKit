FROM ubuntu:14.04
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

RUN apt-get update && apt-get install -y openjdk-7-jre-headless wget zip

# openHAB2 
RUN mkdir /opt/openhab2
RUN wget https://openhab.ci.cloudbees.com/job/openHAB2/lastSuccessfulBuild/artifact/distribution/target/distribution-2.0.0-SNAPSHOT-demo.zip -O /opt/openhab2/openhab2.zip
RUN cd /opt/openhab2 && unzip openhab2.zip

# IoTKit SMD Shield AddOn
RUN wget https://github.com/mc-b/IoTKit/releases/download/V1.0/ch.iotkit.smarthome.binding.mbedRPC_1.0.0.201511131556.jar -O /opt/openhab2/addons/ch.iotkit.smarthome.binding.mbedRPC_1.0.0.201511131556.jar

EXPOSE 8080

ENTRYPOINT cd /opt/openhab2 && ./start_debug.sh


