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

IMAGE=marcel1691/cordova
CONTAINER=cordova
PORT=32300

# Usage
all:
	@echo "usage:\n \
		make build - Image builden\n \
		make run - Image starten\n \
		make stop - Image stoppen\n \
		make bash - Bash Shell in gestarteten Container oeffnen\n \
		make debug - Container mit Bash statt ENTRYPOINT Eintrag starten\n\
		make logs - stdout vom Container anzeigen\n\
		make diff - veraenderte Dateien anzeigen"

# Docker Image builden
build:
	docker build -t $(IMAGE) .

# Docker Image detached starten
run: 
	docker run -d -p $(PORT):8080 --restart=always --name $(CONTAINER) -h $(CONTAINER) \
		-v $(HOME)/ws/IoTKit/Web-App:/var/cordova \
		-v /var/www/html/download:/var/www/html/download \
		$(IMAGE)

# Shell im laufenden Container aufrufen	
bash:
	docker exec -it $(CONTAINER) bash
	
# Browser mit Daten anzeigen
show:
	chromium-browser http://localhost:$(PORT)

	
# Docker Container stoppen und zerstoeren
stop:
	docker stop -t 0 $(CONTAINER)
	docker rm $(CONTAINER)

# Docker Container nur mit bash starten	statt Eintrag in ENTRYPOINT
debug:
	docker run -t -i -p $(PORT):8080 --name $(CONTAINER) -h $(CONTAINER) \
	-v $(HOME)/ws/IoTKit/cordova:/var/cordova \
	-v /var/www/html/download:/var/www/html/download \
	--entrypoint=/bin/bash $(IMAGE)

# Ausgabe auf stdout	
logs:
	docker logs $(CONTAINER)

# Veraenderte Dateien	
diff:
	docker diff $(CONTAINER)	
	
# Image pushen
push:
	docker tag $(IMAGE) localhost:5000/$(CONTAINER)
	docker push localhost:5000/$(CONTAINER)
	docker rmi localhost:5000/$(CONTAINER)
	
# Image pushen (Raspberry Pi)
push.rpi:
	docker tag $(IMAGE) localhost:5000/$(CONTAINER).rpi
	docker push localhost:5000/$(CONTAINER).rpi
	docker rmi localhost:5000/$(CONTAINER).rpi	
	
# Image von localhost holen	
pull:
	docker pull localhost:5000/$(CONTAINER)
	docker tag localhost:5000/$(CONTAINER) $(IMAGE)
	docker rmi localhost:5000/$(CONTAINER)
	
# Image von localhost holen (Raspberry Pi)
pull.rpi:
	docker pull localhost:5000/$(CONTAINER).rpi
	docker tag localhost:5000/$(CONTAINER).rpi $(IMAGE)
	docker rmi localhost:5000/$(CONTAINER).rpi	

	
	