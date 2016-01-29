#!/bin/bash

# install and start Apache & Docker Container  
cd /home/vagrant/ws/IoTKit/docker
sudo apt-get update
make install
make run