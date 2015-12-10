FROM ubuntu:latest
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

RUN export DEBIAN_FRONTEND=noninteractive
RUN apt-get update
RUN apt-get -q -y install apache2 mysql-client mysql-server mercurial git curl wget

# Konfiguration Apache
ENV APACHE_RUN_USER www-data
ENV APACHE_RUN_GROUP www-data
ENV APACHE_LOG_DIR /var/log/apache2

RUN a2enmod cgi

# Konfiguration MySQL
# RUN mysqladmin -u root password admin 
# mysql config - Port fuer alle Hosts oeffnen
RUN sed -i -e"s/^bind-address\s*=\s*127.0.0.1/bind-address = 0.0.0.0/" /etc/mysql/my.cnf

# CGI-Scripts, Datenverzeichnisse, index.html
RUN mkdir -p /usr/lib/cgi-bin
COPY rest /usr/lib/cgi-bin/
COPY restsql /usr/lib/cgi-bin/
COPY showsql /usr/lib/cgi-bin/

RUN mkdir -p /var/www/html/data
RUN chown -R www-data:www-data /var/www/html/data

ADD base /var/www/html/base
COPY index.html /var/www/html/index.html

# WebApp Beispiele
RUN mkdir -p /var/www/html/app
WORKDIR /var/www/html/app
RUN hg clone https://developer.mbed.org/teams/smdiotkit2ch/code/RPCHTTPServerSimple/
RUN hg clone https://developer.mbed.org/teams/smdiotkit2ch/code/RPCHTTPServerVariable/
RUN hg clone https://developer.mbed.org/teams/smdiotkit2ch/code/RPCHTTPServerHandler/

# Initialization Startup Script
ADD start.sh /start.sh
RUN chmod 755 /start.sh

# cgit
WORKDIR /opt
RUN apt-get install -y liblua5.1-0
RUN wget http://de.archive.ubuntu.com/ubuntu/pool/universe/c/cgit/cgit_0.11.2.git2.3.2-1_amd64.deb
RUN dpkg -i cgit_0.11.2.git2.3.2-1_amd64.deb
RUN apt-get install -y -f

WORKDIR /var/www/html
RUN git clone --bare https://github.com/mc-b/IoTKit.git
WORKDIR /var/www/html/iotkit.git
RUN mv hooks/post-update.sample hooks/post-update
RUN chmod a+x hooks/post-update
RUN git update-server-info && \
	touch git-daemon-export-ok
WORKDIR /var/www/html
RUN chown -R www-data:www-data iotkit.git

# cgit Repositories Konfiguration
COPY cgitrc.etc /etc/cgitrc

EXPOSE 80 3306

ENTRYPOINT ["/start.sh"]

