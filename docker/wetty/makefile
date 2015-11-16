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

IMAGE=marcel1691/wetty
CONTAINER=wetty
PORT=33000

# Docker Image builden
build:
	rm -rf wetty
	git clone --depth 1 https://github.com/krishnasrinivas/wetty.git
	rm -rf wetty/.git
	docker build -t $(IMAGE) .

# Docker Image detached starten
run: 
	docker run -d -p $(PORT):3000 --name $(CONTAINER) --link mosquitto:mosquitto --link apache-rest:rest $(IMAGE)

# Shell im laufenden Container aufrufen	
exec:
	docker exec -it $(CONTAINER) bash
	
# Docker Container nur mit bash starten	
debug:
	docker run -t -i -p $(PORT):3000 --name $(CONTAINER) $(IMAGE) /bin/bash
	
# Browser mit Daten anzeigen
show:
	chromium-browser http://localhost:$(PORT)
	
# Ausgabe auf stdout	
logs:
	docker logs $(CONTAINER)

# Veraenderte Dateien	
diff:
	docker diff $(CONTAINER)
	
# Docker Container stoppen und zerstoeren
stop:
	docker stop $(CONTAINER)
	docker rm $(CONTAINER)

	