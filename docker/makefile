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
SUBDIRS=apache-rest leshan mosquitto openhab2 fhem jenkins wetty

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
	
# Loescht alle ungetagten Container und Images	
clean:
	@echo "Deleting untagged images"
	@docker rmi `docker images -q -f dangling=true`	
	@echo "Deleting stopped containers"
	@docker rm `docker ps -a -q`
