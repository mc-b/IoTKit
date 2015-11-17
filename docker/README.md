Docker Images für die Kurse "Internet der Dinge"
================================================

Diese Verzeichnis enthält Dateien um alle Docker Images gemeinsam zu:
* make build - builden
* make run - zu starten
* make stop - zu stoppen
etc.

Ausserdem Startup Scripts zum automatischen Starten der Images bei Systemstart
- init-script - Startup Script Unix Traditionell. Nach /etc/init.d/iot kopieren/umbenennen
 * aktivieren mittels:  update-rc.d defaults
 * deaktivieren mittels: update-rc.d disable
- upstart.conf - Startup Script wenn upstart installiert ist.
 * upstart.conf nach /etc/init/iot.conf kopieren/umbenennen.
Anschliessend muss der Standort der makefile angepasst werden.



 
