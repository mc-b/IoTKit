
== Docker Image fuer Eclipse leshan LWM2M Server ==

Builden
* docker build -t marcel1691/leshan .

Starten
* docker run -d -p 8080:8080 -p 5683:5683/udp  marcel1691/leshan

Der Port 5683 ist fix und muss fuer UDP freigegeben werden. Ansonsten koennen die CoAP Clients sich nicht mit dem Server verbinden.

Für eine Ausführliche Einführung empfehle ich die "Internet der Dinge" Kursreihe an der EB Zürich, Schweiz.
* http://kurs.eb-zuerich.ch/is95


 
