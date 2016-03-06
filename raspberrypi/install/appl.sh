#!/bin/bash
#
# Applikationen
#

apt-get update                                             # Repositories aktualisieren
apt-get -y upgrade                                         # Software aktualisieren
apt-get install -y iceweasel iceweasel-l10n-de             # Chrome + Firefox Browser inkl. lokale Sprache installieren
#apt-get install -y chromium-browser chromium-browser-l10n  # Chrome inkl. lokale Sprache installieren
apt-get install -y libreoffice-help-de libreoffice-l10n-de # Fehlende Sprachpakete LibreOffice 
apt-get install -y dos2unix                                # Hilfsprogramm um DOS Dateien ins UNIX/Linux Format umzuwandeln (d.h. CR entfernen)
#apt-get install -y wpagui                                  # Hilfsprogramm wpa_gui um WLAN zu Konfigurieren
apt-get purge -y dillo netsurf-common                      # Optional: unnötige Browser entfernen
apt-get -y autoremove                                      # aufräumen