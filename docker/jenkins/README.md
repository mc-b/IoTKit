Docker Image fuer Build Server Jenkins
======================================

Erstellt eine yotta (mbed OS V3.x) Umgebung mit Jenkins und einem Job.

Builden
* docker build -t marcel1691/jenkins .

Starten
* docker run -d -p 8080:8080 marcel1691/jenkins

Infrastruktur
-------------
* mbed fähiges Board, z.B. https://developer.mbed.org/platforms/FRDM-K64F/
* Account auf https://developer.mbed.org/
* Docker Image

Testen
------
* Docker Image starten und Server UI auf http://localhost:8080 aufrufen
* für Job example-mbedos-blinky "Build planen"
* Build erscheint links, Console öffnen und wenn verlangt, sich auf https://yotta.mbed.com einloggen
* Programm wird compiliert und kann aus dem Arbeitsbereich auf das Board downgeloadet werden. 



 
