Docker Images für die Kurse "Internet der Dinge"
================================================

Diese Verzeichnis enthält Dateien um alle Docker Images gemeinsam zu:
* make build - builden
* make run - zu starten
* make stop - zu stoppen
etc.

Installation
------------
* Linux z.B. Ubuntu Server installieren oder Cloud Instance erstellen
* Hilfsprogramme und Docker
 - sudo apt-get install -y git make
 - git clone https://github.com/mc-b/IoTKit.git
 - cd IoTKit/docker && make install.docker 
 - Ausloggen und wieder anmelden!
* Übersichtsseite und Apache (Reverse Proxy)
 - cd IoTKit/docker && make install
* Docker Container 
 - makefile editieren und nicht benötigte Docker Images entfernen, Variable: SUBDIRS
 - make run
* Übersichtsseite mittels Browser aufrufen http://<mein Server/

Die Docker Images starten automatisch beim Systemstart. Die Daten bleiben dabei erhalten.

Soll bei jedem Systemstart die Daten zurückgesetzt werden, können folgende Startup Script verwendet werden:
- init-script - Startup Script Unix Traditionell. Nach /etc/init.d/iot kopieren/umbenennen
 * aktivieren mittels:  update-rc.d defaults
 * deaktivieren mittels: update-rc.d disable
- upstart.conf - Startup Script wenn upstart installiert ist.
 * upstart.conf nach /etc/init/iot.conf kopieren/umbenennen.
 * Anschliessend muss der Ordner wo sich die makefiles befinden angepasst werden.



 
