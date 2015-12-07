#!/bin/bash
#
#	Startup fuer Jenkins und Codebox (als User jenkins)
#
java -jar /opt/jenkins/jenkins.war --prefix=/cordova &

/usr/bin/codebox run -t "Web-App IDE" -u ${CODEBOX_USERNAME}:${CODEBOX_PASSWORD} /var/cordova/IoTKit/Web-App
