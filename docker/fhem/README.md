Docker Image für FHEM - Heimautomatisierung
===========================================

Builden
* docker build -t marcel1691/fhem .

Starten
* docker run -d -p 8083:8083 marcel1691/fhem

Infrastruktur
-------------
* mbed fähiges Board, z.B. https://developer.mbed.org/platforms/FRDM-K64F/
* Account auf https://developer.mbed.org/
* Docker Image

Testen
------
* Docker Image starten und Server UI auf http://localhost:8083/fhem aufrufen



 
