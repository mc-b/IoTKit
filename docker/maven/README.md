Docker Image fuer Build Server Jenkins
======================================

Erstellt eine Java Build Umgebung mit maven.

Ausserdem werden Jobs zum Bilden von Eclipse IoT Servern wie Leshan, OpenHAB2 etc. erstellt.

Builden
* docker build -t marcel1691/maven .

Starten
* docker run -d -p 8080:8080 marcel1691/maven




 
