#!/bin/bash

set -o errexit

# German Language Pack
apt-get install -y language-pack-de

# Development Tools
apt-get -y install git mercurial curl wget unzip dos2unix picocom make build-essential

