Docker Image fuer mosquitto MQTT Broker
=======================================

Builden
* docker build -t marcel1691/msoquitto .

Starten
* docker run -d -p 1883:1883  marcel1691/mosquitto

Infrastruktur
-------------
* mbed fähiges Board, z.B. https://developer.mbed.org/platforms/FRDM-K64F/
* Account auf https://developer.mbed.org/
* Docker Image

Testen
------
* Docker Image starten und Server UI auf http://localhost:8080 aufrufen
* Programm https://developer.mbed.org/teams/smdiotkit2ch/code/MQTTPublish/ in mbed Compiler importieren
* Variable hostname (ca. Zeile 9) anpassen auf Docker Container
* Programm compilieren und auf Board speichern
* Das Board publiziert Licht und Poti Daten auf mbed/k64f/iotkit/#

* Lokale MQTT Meldungen empfangen:
 * docker exec -t mosquitto mosquitto_sub -t "#" -v

Weitere Informationen
---------------------
Für eine Ausführliche Einführung empfehle ich die "Internet der Dinge" Kursreihe an der EB Zürich, Schweiz.
* http://kurs.eb-zuerich.ch/is95


 
