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

IMAGE=marcel1691/fhem
CONTAINER=fhem
PORT=32083

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
	@ RC=$(shell docker rm -f $(CONTAINER))
	docker run -d -p $(PORT):8083 --name $(CONTAINER) -h $(CONTAINER) $(IMAGE)

# Shell im laufenden Container aufrufen	
bash:
	docker exec -it $(CONTAINER) bash
		
# Browser mit Daten anzeigen
show:
	chromium-browser http://localhost:$(PORT)/fhem
	
# Docker Container stoppen und zerstoeren
stop:
	docker stop -t 0 $(CONTAINER)
	docker rm $(CONTAINER)

# Docker Container nur mit bash starten	statt Eintrag in ENTRYPOINT
debug:
	docker run -t -i -p $(PORT):8083 --name $(CONTAINER) -h $(CONTAINER) --entrypoint=/bin/bash $(IMAGE)

# Ausgabe auf stdout	
logs:
	docker logs $(CONTAINER)

# Veraenderte Dateien	
diff:
	docker diff $(CONTAINER)
	