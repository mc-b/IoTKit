FROM ubuntu:latest
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

RUN apt-get update
RUN apt-get -y install apache2 mysql-client

ENV APACHE_RUN_USER www-data
ENV APACHE_RUN_GROUP www-data
ENV APACHE_LOG_DIR /var/log/apache2

RUN mkdir -p /usr/lib/cgi-bin
COPY rest /usr/lib/cgi-bin/
COPY restsql /usr/lib/cgi-bin/

RUN mkdir -p /var/www/html/data
RUN chown -R www-data:www-data /var/www/html/data

RUN a2enmod cgi

RUN export DEBIAN_FRONTEND=noninteractive
RUN apt-get -q -y install mysql-server
# RUN mysqladmin -u root password admin 
# mysql config - Port fuer alle Hosts oeffnen
RUN sed -i -e"s/^bind-address\s*=\s*127.0.0.1/bind-address = 0.0.0.0/" /etc/mysql/my.cnf

# Initialization Startup Script
ADD start.sh /start.sh
RUN chmod 755 /start.sh

EXPOSE 80 3306

ENTRYPOINT ["/start.sh"]

