Docker Image für Wetty (Web + tty)
==================================

Wetty ist Terminal in einen Browser. 

In dem Terminal können Clients wie curl, mosquitto etc. ausprobiert werden.

Für weitere Informationen siehe https://github.com/krishnasrinivas/wetty

Installation
- wetty Sourcen in dieses Verzeichnis clonen
 * git clone https://github.com/krishnasrinivas/wetty.git

Builden
* docker build -t marcel1691/wetty .

Starten
* docker run -d -p 3000:3000 marcel1691/wetty

Infrastruktur
-------------
* Browser
* Docker Image

Testen
------
* Docker Image starten und Server UI auf http://localhost:3000 aufrufen
* Einloggen mit guest/guest-
 


 
