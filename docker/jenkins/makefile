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

IMAGE=marcel1691/jenkins
CONTAINER=jenkins
PORT=32200

# Docker Image builden
build:
	docker build -t $(IMAGE) .

# Docker Image detached starten
run: 
	docker run -d -p $(PORT):8080 --name $(CONTAINER) $(IMAGE)

# Shell im laufenden Container aufrufen	
exec:
	docker exec -it $(CONTAINER) bash
	
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
	docker stop -t 0 $(CONTAINER)
	docker rm $(CONTAINER)

	