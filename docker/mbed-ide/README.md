Docker Image mit mbed Entwicklungsumgebung
==========================================

Erstellt eine mbed Entwicklungsumgebung mit
* yotta (mbed OS V3.x) Compiler 
* gcc4arm (mbed OS v2.x) Compiler
* jenkins - Build Server
* codebox - IDE 
* git und Mercurial (hg) Konfigurationsmanagementclients

Das Image basiert auf marcel1691/jenkins und ersetzt diesen.

Builden
* docker build -t marcel1691/mbed-ide .

Starten
* docker run -d -p 8080:8080 -p 8000:8000 marcel1691/mbed-ide

Infrastruktur
-------------
* mbed fähiges Board, z.B. https://developer.mbed.org/platforms/FRDM-K64F/
* Docker Image

Testen
------
- Docker Image starten 
 * Jenkins UI auf http://localhost:8080 oder via Hauptseite öffnen
 * Codebox IDE UI auf http://localhost:8000 oder via Hauptseite öffnen, einloggen mittels codebox/password
- mbed OS V2.x in Jenkins
 * Beispiele auf den Kurs in Gruppen smd.iotkit?.ch "Build planen"
 * Programm wird compiliert und kann aus dem Arbeitsbereich auf das Board downgeloadet werden. 
- mbed OS V2.x in Codebox IDE
 * hg clone https://developer.mbed.org/teams/smdiotkitch/code/AnalogIn/			
 * cd AnalogIn
 * make
 * Programm wird compiliert und kann aus der Workspace auf das Board geladen werden. (Rechte Maustaste auf XYZ.bin -> Download) 
- mbed OS V3.0 in Jenkins
 * für Job example-mbedos-blinky "Build planen"
 * Build erscheint links, Console öffnen und wenn verlangt, sich auf https://yotta.mbed.com einloggen
 * Programm wird compiliert und kann aus dem Arbeitsbereich auf das Board downgeloadet werden. 
- mbed OS V3.x in Codebox IDE
 * git clone https://github.com/ARMmbed/example-mbedos-blinky.git
 * cd example-mbedos-blinky 
 * yotta target frdm-k64f-gcc
 * yotta build 
 * Programm wird compiliert und kann aus der Workspace auf das Board geladen werden. (Rechte Maustaste auf XYZ.bin -> Download) 


 
