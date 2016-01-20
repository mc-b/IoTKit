#!/bin/bash

#set -o errexit

# Remote Desktop via VNC console
sudo apt-get install -y xrdp x11vnc
echo "x11vnc -bg -nevershared -forever -tightfilexfer -nopw -display :0" >>/home/vagrant/.xsessionrc

# swiss german keyboard
#sudo cp /vagrant/km-0807.ini /etc/xrdp 
sudo wget http://www.sero-pcsupport.ch/download/km-0807.ini -O /etc/xrdp/km-0807.ini
sudo chown xrdp:xrdp /etc/xrdp/km-0807.ini
sudo chmod 644 /etc/xrdp/km-0807.ini

# TAB Completion 
sudo sed -i -e 's/switch_window_key/empty/g' /home/vagrant/.config/xfce4/xfconf/xfce-perchannel-xml/xfce4-keyboard-shortcuts.xml

# Terminal 
#sudo sed -i -e 's/DejaVu Sans Mono 9/DejaVu Sans Mono 14/g' /home/vagrant/.config/xfce4/terminal/terminalrc 
#sudo sed -i -e 's/80x24/118x32/g' /home/vagrant/.config/xfce4/terminal/terminalrc 

