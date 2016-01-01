#!/bin/bash

# Yotta (install also gnu-gcc-4-arm)
sudo apt-get -y install python-setuptools cmake ninja-build python-dev libffi-dev libssl-dev && sudo easy_install pip
sudo -H pip install yotta
cd /home/vagrant/ws
sudo -u vagrant git clone https://github.com/ARMmbed/example-mbedos-blinky.git
# cd example-mbedos-blinky.git && yotta make target frdm-k64f && cd -

# ARM Crosscompiler
sudo add-apt-repository ppa:terry.guo/gcc-arm-embedded
sudo apt-get update
sudo apt-get install -y gcc-arm-none-eabi=4.9.3.2015q3-1trusty1

# GCC4ARM 
cd /home/vagrant/ws
sudo -u vagrant git clone https://github.com/adamgreen/gcc4mbed.git
export GCC4MBED_DIR=/home/vagrant/ws/gcc4mbed
export GCC4MBED_TOOLPATH=/usr/bin
export DEVICES=MCU_K64F 
cp /vagrant/MCU_K64F-device.mk ${GCC4MBED_DIR}/build

# cd ${GCC4MBED_DIR} && make    
cd /home/vagrant
echo "export GCC4MBED_DIR=/home/vagrant/ws/gcc4mbed" >>.bashrc
echo "export GCC4MBED_TOOLPATH=/usr/bin" >>.bashrc
echo "export DEVICES=MCU_K64F" >>.bashrc 

# C Umgebung fuer Linux
sudo apt-get install -y clang-3.5 

