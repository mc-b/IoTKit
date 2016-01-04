#!/bin/bash

# Sources
sudo -u vagrant mkdir ws
cd ws
sudo -u vagrant git clone https://github.com/mc-b/IoTKit.git

# install and start Apache & Docker Container  
cd IoTKit/docker
make install
make run