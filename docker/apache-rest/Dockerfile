FROM ubuntu:14.04
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

RUN apt-get update
RUN apt-get -y install apache2

ENV APACHE_RUN_USER www-data
ENV APACHE_RUN_GROUP www-data
ENV APACHE_LOG_DIR /var/log/apache2

RUN mkdir -p /usr/lib/cgi-bin
COPY rest /usr/lib/cgi-bin/
COPY restsql /usr/lib/cgi-bin/

RUN mkdir -p /var/www/html/data
RUN chown -R www-data:www-data /var/www/html/data

RUN a2enmod cgi

EXPOSE 80

CMD ["/usr/sbin/apache2ctl", "-D", "FOREGROUND"]

