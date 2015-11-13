Docker Image fuer openHAB2 Smart Home Server
============================================

Builden
* docker build -t marcel1691/openhab2 .

Starten
* docker run -d -p 8080:8080 marcel1691/openhab2

Infrastruktur
-------------
* mbed fähiges Board, z.B. https://developer.mbed.org/platforms/FRDM-K64F/
* Account auf https://developer.mbed.org/
* Docker Image

Testen
------
* Docker Image starten und Server UI auf http://localhost:8080 aufrufen
* Programm https://developer.mbed.org/teams/smdiotkit2ch/code/RPCHTTPServerSmartHome/ in mbed Compiler importieren
* Verbindung zum Board via Serieller Schnittstelle herstellen und IP-Adresse auslesen
* Programm compilieren und auf Board speichern
* Board mittels Bindings in openHAB2 Konfigurieren

Weitere Informationen
---------------------
Für eine Ausführliche Einführung empfehle ich die "Internet der Dinge" Kursreihe an der EB Zürich, Schweiz.
* http://kurs.eb-zuerich.ch/is95


 
