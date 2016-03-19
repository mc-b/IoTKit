#!/bin/bash


# E-Mail Standard Installation

sudo debconf-set-selections <<< "postfix postfix/mailname string iot-stick"
sudo debconf-set-selections <<< "postfix postfix/main_mailer_type string 'Internet with Smarthost'"
export DEBIAN_FRONTEND=noninteractive

sudo apt-get install -y postfix bsd-mailx 
