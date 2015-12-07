#!/bin/bash
#
#	Startup fuer Jenkins und Codebox (als User jenkins)
#
java -jar /opt/jenkins/jenkins.war --prefix=/mbed &

/usr/bin/codebox run -t "mbed IDE" -u ${CODEBOX_USERNAME}:${CODEBOX_PASSWORD} /var/workspace
