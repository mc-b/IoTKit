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

IMAGE=marcel1691/kura
CONTAINER=kura
PORT=8080

# Docker Image builden
build:
	docker build -t $(IMAGE) .

# Docker Image detached starten
run: 
	@ RC=$(shell docker rm -f $(CONTAINER))
	docker run -d -p $(PORT):8080 -p 8000:8000 --name $(CONTAINER) $(IMAGE)

# Shell im laufenden Container aufrufen	
exec:
	docker exec -it $(CONTAINER) bash
	
# Docker Container nur mit bash starten	
debug:
	docker run -t -i -p $(PORT):8080 -p 8000:8000 --name $(CONTAINER) --privileged -v /dev/bus/usb:/dev/bus/usb $(IMAGE) /bin/bash	
	
# Docker Container nur mit bash starten	
restart:
	docker restart -t --name $(CONTAINER) $(IMAGE) /bin/bash		
	
# Browser mit Daten anzeigen
show:
	chromium-browser http://localhost:$(PORT)	
	
# Docker Container stoppen und zerstoeren
stop:
	docker stop -t 0 $(CONTAINER)
	docker rm $(CONTAINER)

	