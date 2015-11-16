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

IMAGE=marcel1691/mosquitto
CONTAINER=mosquitto
HOST=mosquitto

# Docker Image builden
build:
	docker build -t $(IMAGE) .

# Docker Image detached starten
run: 
	docker run -d -p 1883:1883 -p 9001:9001 -h $(HOST) --name $(CONTAINER) $(IMAGE)

# Shell im laufenden Container aufrufen	
exec:
	docker exec -it $(CONTAINER) bash
	
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

# Subscribe
sub:
	@echo "auf alle Topics vom Broker reagieren" 
	docker exec -t $(CONTAINER) mosquitto_sub -t "#" -v

# Testdaten Publizieren	
pub:
	@echo "Temperator an Topic Zuhause/Wohnzimmer/Temperatur/ mit Q-Level 1 senden"
	docker exec -t $(CONTAINER) mosquitto_pub -t "Zuhause/Wohnzimmer/Temperatur" -m "24.0" -q 1  
	docker exec -t $(CONTAINER) mosquitto_pub -t "Zuhause/Schlafzimmer/Temperatur" -m "21.0" -q 1  
		