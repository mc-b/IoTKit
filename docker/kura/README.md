Docker Image für Eclipse Kura
=============================

Eclipse Kura Umgebung.

Nur für Build, keine lauffähige Umgebung.

Builden
* docker build -t marcel1691/kura .

Starten
* docker run -t -i -p 8080:8080 --name marcel1691/kura --privileged -v /dev/bus/usb:/dev/bus/usb kura /bin/bash

Infrastruktur
-------------
* Browser
* Docker Image

Testen
------
* Docker Image starten und Server UI auf http://localhost:8080 aufrufen
* Einloggen mit admin/admin
 


 
