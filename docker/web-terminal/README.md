Docker Image für web-terminal
=============================

web-terminal ist eine sehr einfache Shell im Browser 

In dem Terminal können Clients wie curl, mosquitto etc. ausprobiert werden.

Für weitere Informationen siehe https://www.npmjs.com/package/web-terminal

Builden
* docker build -t marcel1691/web-terminal .

Starten
* docker run -d -p 3000:3000 marcel1691/web-terminal

Infrastruktur
-------------
* Browser
* Docker Image

Testen
------
* Docker Image starten und Server UI auf http://localhost:3000 aufrufen
 


 
