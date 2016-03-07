#!/bin/bash
#
# Remotedesktop (VNCViewer etc.)
#

# Remote Desktop via VNC console
apt-get install -y xrdp x11vnc
echo "x11vnc -bg -nevershared -forever -tightfilexfer -nopw -display :0" >>/home/pi/.xsessionrc

# swiss german keyboard
#sudo cp /raspberrypi/km-0807.ini /etc/xrdp 
wget http://www.sero-pcsupport.ch/download/km-0807.ini -O /etc/xrdp/km-0807.ini
chown xrdp:xrdp /etc/xrdp/km-0807.ini
chmod 644 /etc/xrdp/km-0807.ini

# TAB Completion 
#sed -i -e 's/switch_window_key/empty/g' /home/vagrant/.config/xfce4/xfconf/xfce-perchannel-xml/xfce4-keyboard-shortcuts.xml


