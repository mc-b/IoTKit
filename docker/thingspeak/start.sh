#!/bin/bash
#
#	Startup MySQL und ThingSpeek
#
service mysql start

# Datenbank noch nicht initialisiert
if [ ! -f /CREATED ] 
then

	# Erstellen des ThingSpeak User 
	mysql -u root <<%EOF%
	create user 'thing'@'localhost' identified by 'speak'; 
	grant usage on *.* to 'thing'@'localhost' identified by 'speak';
	grant all privileges on *.* to 'thing'@'localhost';
	flush privileges;
%EOF%
	
	cd /opt/thingspeak
	rake db:create
	rake db:schema:load
	
	touch /CREATED
fi

# Ruby on Rails Server mit ThingSpeak
rails server