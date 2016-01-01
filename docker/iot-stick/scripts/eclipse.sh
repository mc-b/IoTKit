#!/bin/bash

  
# Eclipse, Arduino, Fritzing
sudo apt-get install -y arduino fritzing
cd /home/vagrant
sudo -u vagrant wget http://ftp.fau.de/eclipse/technology/epp/downloads/release/mars/1/eclipse-cpp-mars-1-linux-gtk-x86_64.tar.gz
sudo -u vagrant tar xvzf eclipse-cpp-mars-1-linux-gtk-x86_64.tar.gz
rm -f eclipse-cpp-mars-1-linux-gtk-x86_64.tar.gz

# GCC4ARM Plug-ins
cd /tmp
wget http://heanet.dl.sourceforge.net/project/gnuarmeclipse/Current%20Releases/2.x/ilg.gnuarmeclipse.repository-2.11.1-201512141335.zip
unzip ilg.gnuarmeclipse.repository-2.11.1-201512141335.zip
sudo -u vagrant cp features/* /home/vagrant/eclipse/features/
sudo -u vagrant cp plugins/*  /home/vagrant/eclipse/plugins