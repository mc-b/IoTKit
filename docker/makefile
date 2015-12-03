# Copyright 2015 Marcel mc-b Bernet
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# Docker Images - wetty muss am Schluss stehen um sich mit den anderen zu verbinden
SUBDIRS=apache-cordova apache-rest fhem jenkins leshan maven mosquitto openhab2 thingspeak wetty
# Raspberry Pi Images (die fehlenden haben Abhaengigkeiten zu i386 Images)
SUBDIRS_RPI=apache-rest fhem leshan maven mosquitto openhab2 web-terminal

# Usage
all:
	@echo "usage:\n \
		make build - alle Images builden\n \
		make run - alle Images starten\n \
		make stop - alle Images stoppen\n \
		make clean - alle untagten Container und Images loeschen"

# Docker Image builden
build:
	for dir in $(SUBDIRS); do \
    	$(MAKE) -C $$dir build; \
	done

# Docker Images auf Raspberry Pi 2! builden. TRICK: Raspi Image als ubuntu:latest tagen.
build.rpi:
	docker pull resin/armv7hf-debian
	docker tag -f resin/armv7hf-debian ubuntu:latest
	for dir in $(SUBDIRS_RPI); do \
    	$(MAKE) -C $$dir build; \
	done

# Docker Image detached starten
run: 
	for dir in $(SUBDIRS); do \
    	$(MAKE) -C $$dir run; \
	done
	
# Docker Container stoppen und zerstoeren
stop: 
	for dir in $(SUBDIRS); do \
    	$(MAKE) -C $$dir stop; \
	done
	
# Loescht alle ungetagten Container 
clean:
	@echo "Deleting stopped containers"
	@docker rm `docker ps -a -q`
	
# Loescht alle ungetagten Images	
cleani:
	@echo "Deleting untagged images"
	@docker rmi `docker images -q -f dangling=true`
	
# Docker auf Ubuntu Installieren	
install.docker:
	sudo apt-key adv --keyserver hkp://pgp.mit.edu:80 --recv-keys 58118E89F3A912897C070ADBF76221572C52609D
	sudo sudo sh -c "echo 'deb https://apt.dockerproject.org/repo ubuntu-trusty main' | tee --append >/etc/apt/sources.list.d/docker.list"
	sudo apt-get update
	sudo apt-cache policy docker-engine
	sudo apt-get install -y docker-engine	
	sudo usermod -a -G docker $(LOGNAME)	

# Docker auf Raspberry Pi installieren
install.docker.rpi:
	sudo wget http://downloads.hypriot.com/docker-hypriot_1.9.1-1_armhf.deb
	sudo dpkg -i docker-hypriot_1.9.1-1_armhf.deb
	sudo usermod -a -G docker pi
	sudo update-rc.d docker defaults

# Installiert die benoetige Host Software (docker muss installiert sein)	
install:
	sudo apt-get install -y apache2 nmap
	sudo a2enmod cgi proxy proxy_html proxy_http xml2enc
	sudo cp apache-proxy/001-default.conf /etc/apache2/sites-enabled/001-default.conf
	sudo cp apache-proxy/network /usr/lib/cgi-bin/
	sudo cp apache-proxy/dockerlogs /usr/lib/cgi-bin/
	sudo usermod -a -G docker www-data
	sudo mkdir -p /var/www/html/download
	sudo chown $(LOGNAME) /var/www/html/download
	sudo service apache2 restart
	$(MAKE) deploy

# nur neue index.html veroeffentlichen
deploy:
	sudo cp apache-proxy/index.html /var/www/html
	sudo cp -r apache-proxy/base /var/www/html
	sudo cp apache-proxy/001-default.conf /etc/apache2/sites-enabled/001-default.conf
	sudo service apache2 restart
		
# Start Docker registry - muss nur einmal ausgefuehrt werden
registry:
	mkdir -p /var/docker/registry/data
	docker run -d -p 5000:5000 --restart=always --name registry \
  	-v /var/docker/registry/data:/var/lib/registry \
  	registry:2

# SSH Tunnel um ohne https: auf die Registry zu pushen
tunnel:
	ssh -N -L 5000:localhost:5000 mbern@iot	
	
# Images taggen um sie anschliessend zu pushen	
push:
	for dir in $(SUBDIRS); do \
    	$(MAKE) -C $$dir push; \
	done		
	
# Images taggen um sie anschliessend zu pushen (Raspberry Pi)
push.rpi:
	for dir in $(SUBDIRS_RPI); do \
    	$(MAKE) -C $$dir push.rpi; \
	done

	
# Images von Registry holen  (Raspberry Pi)
pull.rpi:
	$(MAKE) tunnel
	for dir in $(SUBDIRS_RPI); do \
    	$(MAKE) -C $$dir pull.rpi; \
	done	