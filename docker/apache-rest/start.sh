#!/bin/bash
#
#	Startup fuer Apache mit MySQL und cgi-bin REST Scripts
#

service mysql start

# Erstellen der Datenbank, User und Testdaten
mysql -u root <<%EOF%
create database if not exists sensoren;
create user 'www-data'@'localhost' identified by 'mbed'; 
grant usage on *.* to 'www-data'@'localhost' identified by 'mbed';
grant all privileges on sensoren.* to 'www-data'@'localhost';
flush privileges;
use sensoren;
create table data ( seq INT PRIMARY KEY AUTO_INCREMENT, poti FLOAT, light FLOAT, hall FLOAT, temp FLOAT, created TIMESTAMP DEFAULT CURRENT_TIMESTAMP );
insert into data(poti, light, hall, temp) values ( 0.9, 0.8, 0.49, 25.2 );
insert into data(poti, light, hall, temp) values ( 0.8, 0.7, 0.48, 25.1 );
%EOF%

# Starten Apache Daemon
/bin/bash -c "source /etc/apache2/envvars && exec /usr/sbin/apache2 -DFOREGROUND"

