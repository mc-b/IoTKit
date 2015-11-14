Docker Image mit Apache Web Server und REST Umgebung
====================================================

Demonstriert wie Daten via REST Aufrufen auf dem Server gespeichert werden können.

Builden
* docker build -t marcel1691/apache-rest .

Starten
* docker run -d -p 80:80 --name apache-rest marcel1691/apache-rest
* docker exec -it apache-rest bash

Infrastruktur
* mbed fähiges Board, z.B. https://developer.mbed.org/platforms/FRDM-K64F/
* Account auf https://developer.mbed.org/
* Docker Image
* Optional: curl

Testen mit cURL
---------------
- GET
 * curl http://localhost/cgi-bin/rest - liefert eine hello Message
 * curl http://localhost/cgi-bin/rest/time - die Zeit
 * curl http://localhost/cgi-bin/rest/timestamp - die Zeit in Sekunden
- POST 
 *  curl http://localhost/cgi-bin/rest -X POST -d "light=0.5&temp=1.0&hall=0.42" - speichert den Sensorwert in http://localhost/data/post.txt
- PUT
 * curl http://localhost/cgi-bin/rest/?test.txt -X PUT -d daten - Schreibt daten in die Datei test.txt im data Verzeichnis
- DELETE
 * curl http://localhost/cgi-bin/rest/?test.txt -X DELETE - löscht die Datei test.txt

mbed Programme
--------------
* https://developer.mbed.org/teams/smdiotkit2ch/code/HTTP_GET/
* https://developer.mbed.org/teams/smdiotkit2ch/code/HTTP_POST/
* https://developer.mbed.org/teams/smdiotkit2ch/code/HTTP_PUT/
* https://developer.mbed.org/teams/smdiotkit2ch/code/HTTP_DELETE/

die http.get Aufrufe sind auf das Docker Image abzustimmen bzw. anzupassen.

Standardmässig wird MySQL neben Apache installiert. Daten können mittels dem cgi-bin Script restsql in
die Datenbank geschrieben werden.
* curl http://localhost/cgi-bin/restsql -X POST -d "light=0.5&temp=1.0&hall=0.42"

Zugriff auf die MySQL Commandline
---------------------------------
- docker exec -it apache-rest mysql -uwww-data -pmbed
* Ausgabe der Daten mittels: SELECT * FROM sensoren.data;

Weitere Informationen
---------------------
Für eine Ausführliche Einführung empfehle ich die "Internet der Dinge" Kursreihe an der EB Zürich, Schweiz.
* http://kurs.eb-zuerich.ch/is95


 
