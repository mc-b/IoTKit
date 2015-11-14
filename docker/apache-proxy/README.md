Docker Image mit Apache Web Server Reverse Proxy
================================================

Startet Apache als Reverse Proxy Server für die anderen Docker Images

Builden
* docker build -t marcel1691/apache-proxy .

Starten
* docker run -d -p 80:80 --name apache-proxy marcel1691/apache-proxy





 
