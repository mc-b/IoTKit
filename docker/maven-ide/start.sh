#!/bin/bash
#
#	Startup fuer Jenkins und Codebox (als User jenkins)
#
java -jar /opt/jenkins/jenkins.war --prefix=/maven &

/usr/bin/codebox run -t "Java IDE" -u ${CODEBOX_USERNAME}:${CODEBOX_PASSWORD} /var/workspace
