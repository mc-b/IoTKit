#!/bin/bash

# FreeCAD
sudo add-apt-repository ppa:freecad-maintainers/freecad-stable
sudo apt-get update
sudo apt-get install -y freecad

# Gerbv: Gerber File Viewer
sudo apt-get install -y gerbv

# CAMotics: G-Code Viewer
cd /tmp
sudo wget http://camotics.org/releases/public/release/camotics/ubuntu-precise-64bit/v1.0/camotics_1.0.6_amd64.deb
sudo dpkg -i camotics_1.0.6_amd64.deb
sudo rm camotics_1.0.6_amd64.deb
