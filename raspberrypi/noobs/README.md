NOOBS - New Out of the Box System
=================================

Recovery System
---------------

Ein Recovery System, basierend auf busybox, ist nach Drücken auf SHIFT verfügbar.

Das GUI befindet sich auf ALT+Ctrl+F1, die Consolen ab ALT+Ctrl+F2.

- **Username**: root
- **Password**: raspberry

Custom OS
---------

NOOBS ermöglicht es eigene Custom OS zu erstellen.

Dazu sind die Dateien boot.tar.xz und root.tar.xz zu erstellen und durch die gleichnamigen
Dateien im os/raspian Verzeichnis zu ersetzen.

Starten des Recovery Systems (siehe oben) und Wechsel auf Console:

Einloggen und folgende Befehle eingeben

	mkdir -p /settings/boot /settings/root 

	mount /dev/mmcblk0p6 /settings/boot
	mount /dev/mmcblk0p7 /settings/root 
	mkdir -p /settings/root/os

	cd /settings/boot
	tar -cvpf /media/root/os/boot.tar .

	cd /settings/root
	tar -cvpf /media/root/os/root.tar * --exclude=proc/* --exclude=sys/* --exclude=dev/pts/* --exclude=boot --exclude=tmp --exclude=os

Frisch booten, in Verzeichnis /os wechseln, Dateien komprimieren 

	xz -9 -e /tmp/boot.tar
	xz -9 -e /tmp/root.tar

Komprimierte Dateien nach Raspian auf der FAT32 Partition kopieren.
