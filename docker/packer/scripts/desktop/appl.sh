#!/bin/bash

set -o errexit

# German Language Pack
apt-get install -y language-pack-de

# Desktop Environment
sudo apt-get -y install chromium-browser lxterminal libreoffice libreoffice-l10n-de git mercurial dos2unix picocom gparted gpart vncviewer curl wget unzip build-essential

# obsolete - remove
sudo apt-get -y remove thunderbird abiword gnumeric pidgin gimp ristretto xchat orage