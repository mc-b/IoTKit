Docker Image mit Java/Maven Entwicklungsumgebung
================================================

Erstellt eine mbed Entwicklungsumgebung mit
* Open Java JDK 1.7
* maven
* jenkins - Build Server
* codebox - IDE 
* git 

Das Image basiert auf marcel1691/maven und ersetzt diesen.

Builden
* docker build -t marcel1691/mbed-ide .

Starten
* docker run -d -p 8080:8080 -p 8000:8000 marcel1691/maven-ide

Infrastruktur
-------------
* Docker Image

Testen
------
- Docker Image starten 
 * Jenkins UI auf http://localhost:8080 oder via Hauptseite öffnen
 * Codebox IDE UI auf http://localhost:8000 oder via Hauptseite öffnen, einloggen mittels guest/guest-
 * Terminalfenster aus der IDE starten und z.B. iotkitAPP builden
  * git clone https://github.com/mc-b/IoTKit.git
  * cd IoTKit/Web-App/iotkitAPP/
  * rm -rf platforms/* plugins/*
  * cordova platform add android@3.5.0
  * cordova build
  
 
