#!/bin/bash
#
# Grundkonfiguration OS
#

# Expand Filesystem
raspi-config --expand-rootfs

# Change hostname	
export NEW_HOSTNAME=raspiX
export CURRENT_HOSTNAME=`cat /etc/hostname | tr -d " \t\n\r"`
echo $NEW_HOSTNAME > /etc/hostname
sed -i "s/127.0.1.1.*$CURRENT_HOSTNAME/127.0.1.1\t$NEW_HOSTNAME/g" /etc/hosts

# Locale
localedef -c -f UTF-8 -i de_CH de_CH.UTF-8
update-locale LANG=de_CH.UTF-8

# Keyboard
export NOOBSKEYBOARD=ch
sed -i /etc/default/keyboard -e "s/^XKBLAYOUT.*/XKBLAYOUT=\"$NOOBSKEYBOARD\"/"
dpkg-reconfigure -f noninteractive keyboard-configuration
invoke-rc.d keyboard-setup start

# TimeZone
echo "Europe/Zurich" > /etc/timezone 
dpkg-reconfigure -f noninteractive tzdata

shutdown -r now
