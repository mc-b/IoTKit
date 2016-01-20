#!/bin/bash

set -o errexit

apt-key adv --keyserver hkp://pgp.mit.edu:80 --recv-keys 58118E89F3A912897C070ADBF76221572C52609D
sh -c "echo 'deb https://apt.dockerproject.org/repo ubuntu-trusty main' | tee --append >/etc/apt/sources.list.d/docker.list"
apt-get update
apt-get install -y docker-engine	
usermod -a -G docker vagrant	