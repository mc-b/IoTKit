Docker Image fuer Eclipse leshan LWM2M Server
=============================================

Builden
* docker build -t marcel1691/leshan .

Starten
* docker run -d -p 8080:8080 -p 5683:5683/udp  marcel1691/leshan

Der Port 5683 ist fix und muss fuer UDP freigegeben werden. Ansonsten koennen die CoAP Clients sich nicht mit dem Server verbinden.

Infrastruktur
-------------
* mbed fähiges Board, z.B. https://developer.mbed.org/platforms/FRDM-K64F/
* Account auf https://developer.mbed.org/
* Docker Image

Testen
------
* Docker Image starten und Server UI auf http://localhost:8080 aufrufen
* Programm https://developer.mbed.org/teams/smdiotkit2ch/code/COAPleshan/ in mbed Compiler importieren
* ca. Zeile 27, IP-Adresse des Docker-Images setzen
* Programm compilieren und auf Board speichern
* Board sollte im Server UI sichtbar sein und Daten wie Manufacturer sollten lesbar und Object10/led1 bis 3 les- und schreibbar sein.

Weitere Informationen
---------------------
Für eine Ausführliche Einführung empfehle ich die "Internet der Dinge" Kursreihe an der EB Zürich, Schweiz.
* http://kurs.eb-zuerich.ch/is95


 
