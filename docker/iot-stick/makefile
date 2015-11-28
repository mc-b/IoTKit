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

# Grundinstallation auf XUbuntu 14.04
install:
	sudo apt-get -y install chromium-browser lxterminal arduino fritzing libreoffice libreoffice-l10n-de git mercurial dos2unix picocom gparted gpart vncviewer curl build-essential
	sudo apt-get -y remove firefox thunderbird abiword gnumeric pidgin gimp ristretto xchat orage
	sudo apt-get -y autoremove
	sudo apt-get update && sudo apt-get -y upgrade
	
# Neue Version FreeCAD	
install.freecad:
	sudo add-apt-repository ppa:freecad-maintainers/freecad-stable
	sudo apt-get update
	sudo apt-get install -y freecad

# Yotta
install.yotta:
	sudo apt-get -y install python-setuptools cmake ninja-build python-dev libffi-dev libssl-dev && sudo easy_install pip
	sudo -H pip install yotta

# ARM Crosscompiler
install.gcc4arm
	sudo add-apt-repository ppa:terry.guo/gcc-arm-embedded
	sudo apt-get update
	sudo apt-get install -y gcc-arm-none-eabi=4.9.3.2015q3-1trusty1

# C Umgebung fuer Linux
install.c:
	sudo apt-get install -y clang-3.5

# Java8 als Standard setzen, vorher Java8 downloaden und unter /opt/java installieren
default.java:
	sudo update-alternatives --install "/usr/bin/java" "java" "/opt/java/bin/java" 1
	sudo update-alternatives --install "/usr/bin/javac" "javac" "/opt/java/bin/javac" 1
	sudo update-alternatives --install "/usr/bin/javaws" "javaws" "/opt/java/bin/javaws" 1
	sudo update-alternatives --install "/usr/bin/jar" "jar" "/opt/java/bin/jar" 1 
	sudo update-alternatives --set "java" "/opt/java/bin/java"
	sudo update-alternatives --set "javac" "/opt/java/bin/javac"
	sudo update-alternatives --set "javaws" "/opt/java/bin/javaws"
	sudo update-alternatives --set "jar" "/opt/java/bin/jar" 
	