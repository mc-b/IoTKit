FROM ubuntu:latest
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

RUN apt-get update
RUN apt-get -y install apache2 apache2-threaded-dev libapache2-mod-proxy-html libxml2-dev

ENV APACHE_RUN_USER www-data
ENV APACHE_RUN_GROUP www-data
ENV APACHE_LOG_DIR /var/log/apache2

RUN mkdir -p /usr/lib/cgi-bin
RUN a2enmod cgi proxy proxy_html proxy_http xml2enc

ADD base /var/www/html/base
COPY index.html /var/www/html/index.html
COPY 001-default.conf /etc/apache2/sites-enabled/001-default.conf

EXPOSE 80

# Configure localhost in Apache
RUN echo "ServerName localhost" >> /etc/apache2/apache2.conf

# Define default command
CMD ["apachectl", "-D", "FOREGROUND"]


