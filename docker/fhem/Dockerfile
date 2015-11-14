FROM ubuntu:latest
MAINTAINER Marcel mc-b Bernet <marcel.bernet@ch-open.ch>

ENV DEBIAN_FRONTEND noninteractive

RUN apt-get update
RUN apt-get -y --force-yes install wget apt-transport-https

# Install perl packages
RUN apt-get -y --force-yes install libalgorithm-merge-perl \
	libclass-isa-perl \
	libcommon-sense-perl \
	libdpkg-perl \
	liberror-perl \
	libfile-copy-recursive-perl \
	libfile-fcntllock-perl \
	libio-socket-ip-perl \
	libjson-perl \
	libjson-xs-perl \
	libmail-sendmail-perl \
	libsocket-perl \
	libswitch-perl \
	libsys-hostname-long-perl \
	libterm-readkey-perl \
	libterm-readline-perl-perl \
	libdevice-serialport-perl \
	libwww-perl \
	libio-socket-ssl-perl	

RUN echo Europe/Zurich > /etc/timezone && dpkg-reconfigure tzdata

RUN wget http://fhem.de/fhem-5.6.deb -O /opt/fhem.deb
RUN dpkg -i /opt/fhem.deb

RUN echo 'attr global nofork 1\n' >> /opt/fhem/fhem.cfg

VOLUME ["/opt/fhem"]
EXPOSE 8083

ENTRYPOINT cd /opt/fhem && perl fhem.pl fhem.cfg