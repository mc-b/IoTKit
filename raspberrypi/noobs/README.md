NOOBS - New Out of the Box System
=================================

Recovery System
---------------

Ein Recovery System, basierend auf busybox, ist nach Drücken auf SHIFT verfügbar.

Das GUI befindet sich auf ALT+F1, die Consolen ab ALT+F2.

Username: root
Password: raspberry

Custom OS
---------

NOOBS ermöglicht es eigene Custom OS zu erstellen.

Dazu sind die Dateien boot.tar.xz und root.tar.xz zu erstellen und durch die gleichnamigen
Dateien im os/raspian Verzeichnis zu ersetzen.

Starten des Recovery Systems (siehe oben):

Einloggen und folgende Befehle eingeben

mkdir -p /media/boot /media/root 

mount /dev/mmcblk0p6 /media/boot
mount /dev/mmcblk0p5 /media/root 
mkdir -p /media/root/os

cd /media/boot
tar -cvpJf /media/root/os/boot.tar .

cd /media/root
tar -cvpJf /media/root/os/root.tar * --exclude=proc/* --exclude=sys/* --exclude=dev/pts/* --exclude=boot --exclude=tmp

Frisch booten und Dateien unter dem /os Verzeichnis auf PC kopieren und wie oben abstellen.

