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

IMAGE=marcel1691/apache-rest
CONTAINER=apache-rest
PORT=32000

# Docker Image builden
build:
	docker build -t $(IMAGE) .

# Docker Image detached starten
run:
	@ RC=$(shell docker rm -f $(CONTAINER))
	docker run -d -p $(PORT):80 -p 3306:3306 --name $(CONTAINER) $(IMAGE)

# Shell im laufenden Container aufrufen	
exec:
	docker exec -it $(CONTAINER) bash
	
# SQL Console aufrufen
sql:
	@echo "use: SELECT * FROM sensoren.data;"
	@docker exec -it test-apache mysql -uwww-data -pmbed 

# Browser mit Daten anzeigen
show:
	chromium-browser http://localhost:$(PORT)/data	
	
# Docker Container stoppen und zerstoeren
stop:
	docker stop -t 0 $(CONTAINER)
	docker rm $(CONTAINER)

# Tests	
test:
	@echo "---------- HTTP GET ----------"
	curl http://localhost:$(PORT)/cgi-bin/rest
	curl http://localhost:$(PORT)/cgi-bin/rest/time
	curl http://localhost:$(PORT)/cgi-bin/rest/timestamp
	@echo "---------- HTTP POST ----------"
	curl http://localhost:$(PORT)/cgi-bin/rest -X POST -d "light=0.5&temp=1.0&hall=0.42"
	@echo "---------- HTTP PUT ----------"
	curl http://localhost:$(PORT)/cgi-bin/rest/?test.txt -X PUT -d daten
	@echo "---------- HTTP DELETE ----------"
	curl http://localhost:$(PORT)/cgi-bin/rest/?test.txt -X DELETE
	@echo "---------- HTTP POST (SQL-Variante) ----------"
	curl http://localhost:$(PORT)/cgi-bin/restsql -X POST -d "light=0.5&temp=1.0&hall=0.42"
	